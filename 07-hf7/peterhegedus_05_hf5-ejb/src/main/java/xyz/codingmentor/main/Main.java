package xyz.codingmentor.main;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.beans.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import xyz.codingmentor.beans.Color;
import static xyz.codingmentor.beans.Color.WHITE;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.beans.Manufacturer;
import static xyz.codingmentor.beans.Manufacturer.HTC;
import xyz.codingmentor.beans.Sex;
import static xyz.codingmentor.beans.Sex.MALE;
import xyz.codingmentor.cart.ShoppingCart;
import xyz.codingmentor.database.DeviceDB;
import xyz.codingmentor.database.UserDB;

/**
 *
 * @author Péter
 */
public class Main {

    private Main() {

    }

    public static void main(String[] args) {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        UserDB userDBInit = container.instance().select(UserDB.class).get();
        DeviceDB deviceDBInit = container.instance().select(DeviceDB.class).get();
        List<UserEntity> users = generateUserList(userDBInit);
        List<Device> devices = generateDeviceList(deviceDBInit);
        UserDB userDB = container.instance().select(UserDB.class).get();
        DeviceDB deviceDB = container.instance().select(DeviceDB.class).get();

        writeUserToFile(users);
        writeDeviceToFile(devices);
        generateUserListFromJson(userDB);
        generateDeviceListFromJson(deviceDB);

        cartAndDeviceTestMethod(deviceDB);
        userTestMethod(userDB);

    }

    public static void userTestMethod(UserDB userDB) {
        UserEntity testUser = userDB.getUser(userDB.getAllUser().get(0).getUsername());
        userDB.authenticate(testUser.getUsername(), testUser.getPassword());
        userDB.modifyUser(testUser);
        userDB.deleteUser(testUser);
    }

    public static void cartAndDeviceTestMethod(DeviceDB deviceDB) {
        ShoppingCart cart = new ShoppingCart(deviceDB);
        Device testDevice = deviceDB.getAllDevice().get(0);
        testDevice.setCount(3);
        deviceDB.editDevice(testDevice);
        cart.addDevice(deviceDB.getDevice(testDevice.getId()).getId(), 3);
        cart.buyCart();
        deviceDB.deleteDevice(testDevice);
    }

    public static UserEntity generateUser(String username, String password, String address, String phone, String email, Sex sex) {
        return new UserEntity.Builder().username(username)
                .password(password)
                .firstname(null)
                .lastname(null)
                .address(address)
                .phone(phone)
                .email(email)
                .sex(sex)
                .dateOfBirth(null)
                .admin(false)
                .build();
    }

    public static List<UserEntity> generateUserList(UserDB users) {
        String address = "1234 Budapest, Valami utca 2.";
        String phone = "06301234567";
        String email = "pistike@ize.hu";
        Sex sex = MALE;
        users.addUser(generateUser("pistike1", "Abc12d1", address, phone, email, sex));
        users.addUser(generateUser("pistike2", "Abc12d2", address, phone, email, sex));
        users.addUser(generateUser("pistike3", "Abc12d3", address, phone, email, sex));
        users.addUser(generateUser("pistike4", "Abc12d4", address, phone, email, sex));
        users.addUser(generateUser("pistike5", "Abc12d5", address, phone, email, sex));
        users.addUser(generateUser("pistike6", "Abc12d6", address, phone, email, sex));
        users.addUser(generateUser("pistike7", "Abc12d7", address, phone, email, sex));
        users.addUser(generateUser("pistike8", "Abc12d8", address, phone, email, sex));
        users.addUser(generateUser("pistike9", "Abc12d9", address, phone, email, sex));
        users.addUser(generateUser("pistike10", "Abc12d10", address, phone, email, sex));

        return users.getAllUser();
    }

    public static List<Device> generateDeviceList(DeviceDB devices) {

        Manufacturer manufacturer = HTC;
        int price = 30000;
        Color color = WHITE;
        Integer count = 0;

        devices.addDevice(new Device(manufacturer, "One", price, color, count));
        devices.addDevice(new Device(manufacturer, "Two", price, color, count));
        devices.addDevice(new Device(manufacturer, "Three", price, color, count));
        devices.addDevice(new Device(manufacturer, "Four", price, color, count));
        devices.addDevice(new Device(manufacturer, "Five", price, color, count));
        devices.addDevice(new Device(manufacturer, "Six", price, color, count));
        devices.addDevice(new Device(manufacturer, "Seven", price, color, count));
        devices.addDevice(new Device(manufacturer, "Eight", price, color, count));
        devices.addDevice(new Device(manufacturer, "Nine", price, color, count));
        devices.addDevice(new Device(manufacturer, "Ten", price, color, count));

        return devices.getAllDevice();

    }

    public static void writeUserToFile(List<UserEntity> users) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("user.json");
        try {
            mapper.writeValue(file, users);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void writeDeviceToFile(List<Device> devices) {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("device.json");
        try {
            mapper.writeValue(file, devices);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void generateUserListFromJson(UserDB userDB) {
        ObjectMapper mapper = new ObjectMapper();
        List<UserEntity> userList = new ArrayList<>();

        try {
            userList = mapper.readValue(new File("user.json"), new TypeReference<List<UserEntity>>() {
            });
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (UserEntity user : userList) {
            userDB.addUser(user);
        }
    }

    public static void generateDeviceListFromJson(DeviceDB deviceDB) {
        ObjectMapper mapper = new ObjectMapper();
        List<Device> deviceList = new ArrayList<>();

        try {
            deviceList = mapper.readValue(new File("device.json"), new TypeReference<List<Device>>() {
            });
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Device device : deviceList) {
            deviceDB.addDevice(device);
        }
    }
}
