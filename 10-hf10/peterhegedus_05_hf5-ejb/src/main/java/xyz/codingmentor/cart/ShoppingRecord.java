package xyz.codingmentor.cart;

import java.io.Serializable;
import xyz.codingmentor.beans.Device;

/**
 *
 * @author Péter
 */
public class ShoppingRecord implements Serializable {

    private Device device;
    private int count;

    public ShoppingRecord(Device device, int count) {
        this.device = device;
        this.count = count;
    }

    public Device getDevice() {
        return device;
    }

    public int getCount() {
        return count;
    }

    public void setDevice(Device device) {
        this.device = device;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ShoppingRecord{" + "device=" + device + ", count=" + count + '}';
    }

}
