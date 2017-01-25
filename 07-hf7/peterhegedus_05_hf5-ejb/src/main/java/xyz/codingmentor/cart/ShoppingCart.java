package xyz.codingmentor.cart;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.database.DeviceDB;
import xyz.codingmentor.exceptions.ShoppingCartNotEnoughDeviceInCartException;
import xyz.codingmentor.exceptions.ShoppingCartNotEnoughDeviceToBuyException;
import xyz.codingmentor.exceptions.ShoppingCartNotFoundDeviceException;

/**
 *
 * @author Péter
 */

public class ShoppingCart {

    private static final Logger LOG = Logger.getAnonymousLogger();

    private final DeviceDB deviceDB;

    private final Map<String, ShoppingRecord> products;

    private int sumPrice;

    public ShoppingCart(DeviceDB deviceDB) {
        this.products = new HashMap<>();
        this.sumPrice = 0;
        this.deviceDB = deviceDB;
    }

    public void addDevice(String id, Integer count) {
        Device actDevice = deviceDB.getDevice(id);
        if (actDevice.getCount() >= count) {
            ShoppingRecord actRecord = new ShoppingRecord(actDevice, count);
            products.put(id, actRecord);
            actDevice.setCount(actDevice.getCount() - count);
            deviceDB.editDevice(actDevice);
            sumPrice += actDevice.getPrice() * count;
        } else {
            throw new ShoppingCartNotEnoughDeviceToBuyException(actDevice.getId());
        }

    }

    public void removeDevice(String id, int count) {
        Device actDevice = deviceDB.getDevice(id);
        if (products.containsKey(id)) {
            ShoppingRecord actRecord = products.get(id);
            if (actRecord.getCount() > count) {
                actDevice.setCount(actDevice.getCount() + count);
                actRecord.getDevice().setCount(actRecord.getDevice().getCount() - count);
                deviceDB.editDevice(actDevice);
                sumPrice -= actDevice.getPrice() * count;
            } else if (actRecord.getCount() == count) {
                actDevice.setCount(actDevice.getCount() + count);
                deviceDB.editDevice(actDevice);
                products.remove(id);
                sumPrice -= actDevice.getPrice() * count;
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

    public void buyCart() {
        for (Map.Entry<String, ShoppingRecord> entry : products.entrySet()) {
            LOG.log(Level.INFO, "Device bought:  {0} {1}, count: {2}, price: {3}",
                    new Object[]{entry.getValue().getDevice().getManufacturer(),
                        entry.getValue().getDevice().getType(),
                        entry.getValue().getCount(),
                        this.sumPrice});
            removeDevice(entry.getKey(), entry.getValue().getCount());
        }
    }

}
