package xyz.codingmentor.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.exceptions.DeviceDBAlreadyThereException;
import xyz.codingmentor.exceptions.DeviceDBNotFoundException;

/**
 *
 * @author Péter
 */
public class DeviceDB {

    private final Map<String, Device> data;

    public DeviceDB() {
        data = new HashMap<>();
    }

    public Device addDevice(Device device) {
        if (!data.containsValue(device)) {
            device.setId(UUID.randomUUID().toString());
            device.setCount(0);

            data.put(device.getId(), device);
            return device;
        }
        throw new DeviceDBAlreadyThereException(device.getId());

    }

    public Device editDevice(Device deviceEntity) {
        if (null != data && data.containsKey(deviceEntity.getId())) {
            data.put(deviceEntity.getId(), deviceEntity);
            return data.get(deviceEntity.getId());
        }
        throw new DeviceDBNotFoundException(deviceEntity.getId());
    }

    public Device getDevice(String id) {
        if (null != data && data.containsKey(id)) {
            return data.get(id);
        }
        throw new DeviceDBNotFoundException(id);
    }

    public Device deleteDevice(Device deviceEntity) {
        if (null != data && data.containsKey(deviceEntity.getId())) {
            return data.remove(deviceEntity.getId());
        }
        throw new DeviceDBNotFoundException(deviceEntity.getId());
    }

    public List<Device> getAllDevice() {
        return new ArrayList<>(data.values());
    }

}
