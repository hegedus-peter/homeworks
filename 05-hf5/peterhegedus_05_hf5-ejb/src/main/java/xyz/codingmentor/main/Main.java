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
import xyz.codingmentor.beans.Color;
import static xyz.codingmentor.beans.Color.WHITE;
import xyz.codingmentor.beans.Device;
import xyz.codingmentor.beans.Manufacturer;
import static xyz.codingmentor.beans.Manufacturer.HTC;
import xyz.codingmentor.beans.Sex;
import static xyz.codingmentor.beans.Sex.MALE;
import xyz.codingmentor.database.DeviceDB;
import xyz.codingmentor.database.UserDB;

/**
 *
 * @author Péter
 */
public class Main {
    
    private Main(){
        
    }

    public static void main(String[] args) {
        List<UserEntity> users = generateUserList();
        List<Device> devices = generateDeviceList();

        writeUserToFile(users);
        writeDeviceToFile(devices);

        UserDB userDB=new UserDB();
        generateUserListFromJson(userDB);
        DeviceDB deviceDB=new DeviceDB();
        generateDeviceListFromJson(deviceDB);
        
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

    public static List<UserEntity> generateUserList() {
        String address = "1234 Budapest, Valami utca 2.";
        String phone = "06301234567";
        String email = "pistike@ize.hu";
        Sex sex = MALE;

        List<UserEntity> userList = new ArrayList<>();
        userList.add(generateUser("pistike1", "Abc12d1", address, phone, email, sex));
        userList.add(generateUser("pistike2", "Abc12d2", address, phone, email, sex));
        userList.add(generateUser("pistike3", "Abc12d3", address, phone, email, sex));
        userList.add(generateUser("pistike4", "Abc12d4", address, phone, email, sex));
        userList.add(generateUser("pistike5", "Abc12d5", address, phone, email, sex));
        userList.add(generateUser("pistike6", "Abc12d6", address, phone, email, sex));
        userList.add(generateUser("pistike7", "Abc12d7", address, phone, email, sex));
        userList.add(generateUser("pistike8", "Abc12d8", address, phone, email, sex));
        userList.add(generateUser("pistike9", "Abc12d9", address, phone, email, sex));
        userList.add(generateUser("pistike10", "Abc12d10", address, phone, email, sex));

        return userList;
    }

    public static List<Device> generateDeviceList() {

        Manufacturer manufacturer = HTC;
        int price = 30000;
        Color color = WHITE;
        Integer count = 0;

        List<Device> deviceList = new ArrayList<>();
        deviceList.add(new Device(manufacturer, "One", price, color, count));
        deviceList.add(new Device(manufacturer, "Two", price, color, count));
        deviceList.add(new Device(manufacturer, "Three", price, color, count));
        deviceList.add(new Device(manufacturer, "Four", price, color, count));
        deviceList.add(new Device(manufacturer, "Five", price, color, count));
        deviceList.add(new Device(manufacturer, "Six", price, color, count));
        deviceList.add(new Device(manufacturer, "Seven", price, color, count));
        deviceList.add(new Device(manufacturer, "Eight", price, color, count));
        deviceList.add(new Device(manufacturer, "Nine", price, color, count));
        deviceList.add(new Device(manufacturer, "Ten", price, color, count));

        return deviceList;

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
