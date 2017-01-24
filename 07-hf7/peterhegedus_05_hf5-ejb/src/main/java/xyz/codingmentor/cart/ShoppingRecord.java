package xyz.codingmentor.cart;

import xyz.codingmentor.beans.Device;

/**
 *
 * @author Péter
 */
public class ShoppingRecord {

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

}
