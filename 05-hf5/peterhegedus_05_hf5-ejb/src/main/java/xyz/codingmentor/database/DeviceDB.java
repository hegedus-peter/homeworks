package xyz.codingmentor.database;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.exceptions.DeviceDBException;

/**
 *
 * @author Péter
 */
public class DeviceDB {

    private final List<Device> data;

    public DeviceDB() {
        data = new ArrayList<>();
    }

    public Device addDevice(Device device) {
        device.setId(UUID.randomUUID().toString());
        device.setCount(0);

        data.add(device);
        return device;
    }

    public Device editDevice(Device deviceEntity) {
        if (null != data) {
            for (Device device : data) {
                if (device.getId().equals(deviceEntity.getId())) {
                    device = deviceEntity;
                    return device;
                }
            }
            throw new DeviceDBException();
        }
        throw new DeviceDBException();
    }

    public Device getDevice(String id) {
        if (null != data) {
            for (Device device : data) {
                if (device.getId().equals(id)) {
                    return device;
                }
            }
            throw new DeviceDBException();
        }
        throw new DeviceDBException();
    }

    public Device deleteDevice(Device deviceEntity) {
        Device deletedDevice;
        if (null != data) {
            for (Device device : data) {
                if (device.getId().equals(deviceEntity.getId())) {
                    deletedDevice = device;
                    data.remove(device);
                    return deletedDevice;
                }
            }
            throw new DeviceDBException();
        }
        throw new DeviceDBException();
    }

    public List<Device> getAllDevice() {
        return this.data;
    }

}
