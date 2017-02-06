package xyz.codingmentor.singleton;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.beans.UserEntity;

/**
 *
 * @author Péter
 */
@Singleton
@Startup
public class EntityManagerSingleton {

    @Inject
    private DeviceDB deviceDB;
    @Inject
    private UserDB userDB;

    public EntityManagerSingleton() {
        //generated
    }

    @PostConstruct
    public void init() {
        generateUserListFromJson(userDB);
        generateDeviceListFromJson(deviceDB);
    }

    public void generateUserListFromJson(UserDB userDB) {
        ObjectMapper mapper = new ObjectMapper();
        List<UserEntity> userList = new ArrayList<>();

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("user.json").getFile());
            userList = mapper.readValue(file, new TypeReference<List<UserEntity>>() {
            });
        } catch (IOException ex) {
            Logger.getLogger(EntityManagerSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (UserEntity user : userList) {
            userDB.addUser(user);
        }
    }

    public void generateDeviceListFromJson(DeviceDB deviceDB) {
        ObjectMapper mapper = new ObjectMapper();
        List<Device> deviceList = new ArrayList<>();

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("device.json").getFile());
            deviceList = mapper.readValue(file, new TypeReference<List<Device>>() {
            });
        } catch (IOException ex) {
            Logger.getLogger(EntityManagerSingleton.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Device device : deviceList) {
            deviceDB.addDevice(device);
        }
    }

}
