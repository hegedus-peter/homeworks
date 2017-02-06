package xyz.codingmentor.singleton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.ejb.Singleton;
import javax.interceptor.ExcludeClassInterceptors;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.constraint.Interceptable;
import xyz.codingmentor.exceptions.DeviceDBAlreadyThereException;
import xyz.codingmentor.exceptions.DeviceDBDeviceNotFoundException;

/**
 *
 * @author Péter
 */
@Interceptable
@Singleton
public class DeviceDB implements Serializable {

    private final Map<String, Device> data;

    public DeviceDB() {
        data = new HashMap<>();
    }

    @ExcludeClassInterceptors
    public Device addDevice(Device device) {
        if (!data.containsValue(device)) {
            device.setId(UUID.randomUUID().toString());

            /**
             * device.setCount(0); Tesztelés miatt kivéve, ha bent marad, a
             * hozzáadott JSON Device count értéke eldobódna
             */
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
        throw new DeviceDBDeviceNotFoundException(deviceEntity.getId());
    }

    public Device getDevice(String id) {
        if (null != data && data.containsKey(id)) {
            return data.get(id);
        }
        throw new DeviceDBDeviceNotFoundException(id);
    }

    public Device deleteDevice(Device deviceEntity) {
        if (null != data && data.containsKey(deviceEntity.getId())) {
            return data.remove(deviceEntity.getId());
        }
        throw new DeviceDBDeviceNotFoundException(deviceEntity.getId());
    }

    public List<Device> getAllDevice() {
        return new ArrayList<>(data.values());
    }

    public void clear() {
        this.data.clear();
    }

}
