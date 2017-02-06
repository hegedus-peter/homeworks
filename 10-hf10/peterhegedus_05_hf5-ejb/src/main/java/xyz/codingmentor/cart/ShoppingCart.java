package xyz.codingmentor.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.inject.Inject;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.singleton.DeviceDB;
import xyz.codingmentor.exceptions.ShoppingCartNotEnoughDeviceInCartException;
import xyz.codingmentor.exceptions.ShoppingCartNotEnoughDeviceToBuyException;
import xyz.codingmentor.exceptions.ShoppingCartNotFoundDeviceException;

/**
 *
 * @author Péter
 */
@Stateful
@StatefulTimeout(value = 200, unit = TimeUnit.SECONDS)
public class ShoppingCart implements Serializable {

    private static final Logger LOG = Logger.getAnonymousLogger();

    @Inject
    private DeviceDB deviceDB;

    private final Map<String, ShoppingRecord> products;

    private int sumPrice;

    public ShoppingCart() {
        this.products = new HashMap<>();
        this.sumPrice = 0;
    }

    public Device addDevice(String id, Integer count) {
        Device actDevice = deviceDB.getDevice(id);
        if (actDevice.getCount() >= count) {
            int actCount = count;
            if (products.containsKey(id)) {
                actCount = products.get(id).getCount() + count;
            }
            ShoppingRecord actRecord = new ShoppingRecord(actDevice, actCount);
            products.put(id, actRecord);
            actDevice.setCount(actDevice.getCount() - count);
            deviceDB.editDevice(actDevice);
            sumPrice += actDevice.getPrice() * count;
            return actDevice;
        } else {
            throw new ShoppingCartNotEnoughDeviceToBuyException(actDevice.getId());
        }
    }

    public Device removeDevice(String id, int count) {
        Device actDevice = deviceDB.getDevice(id);
        if (products.containsKey(id)) {
            ShoppingRecord actRecord = products.get(id);
            if (actRecord.getCount() > count) {
                actDevice.setCount(actDevice.getCount() + count);
                actRecord.setCount(actRecord.getCount() - count);
                deviceDB.editDevice(actDevice);
                sumPrice -= actDevice.getPrice() * count;
                return actDevice;
            } else if (actRecord.getCount() == count) {
                actDevice.setCount(actDevice.getCount() + count);
                deviceDB.editDevice(actDevice);
                products.remove(id);
                sumPrice -= actDevice.getPrice() * count;
                return actDevice;
            } else {
                throw new ShoppingCartNotEnoughDeviceInCartException(id);
            }
        } else {
            throw new ShoppingCartNotFoundDeviceException(id);
        }
    }

    public void discardAll() {
        for (Map.Entry<String, ShoppingRecord> entry : products.entrySet()) {
            removeDevice(entry.getKey(), entry.getValue().getCount());
        }
    }

    public int getSumPrice() {
        return this.sumPrice;
    }

    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }

    @Remove
    public List<ShoppingRecord> buyCart() {
        List<ShoppingRecord> records = new ArrayList<>(products.values());
        for (Map.Entry<String, ShoppingRecord> entry : products.entrySet()) {
            LOG.log(Level.INFO, "Device bought:  {0} {1}, count: {2}, price: {3}",
                    new Object[]{entry.getValue().getDevice().getManufacturer(),
                        entry.getValue().getDevice().getType(),
                        entry.getValue().getCount(),
                        entry.getValue().getDevice().getPrice() * entry.getValue().getCount()});
        }
        LOG.log(Level.INFO, "Full price: {0}", this.sumPrice);
        return records;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "products=" + products + ", sumPrice=" + sumPrice + '}';
    }

}
