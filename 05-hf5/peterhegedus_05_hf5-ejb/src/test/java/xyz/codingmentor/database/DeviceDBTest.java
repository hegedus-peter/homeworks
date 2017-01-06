package xyz.codingmentor.database;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import xyz.codingmentor.beans.Color;
import static xyz.codingmentor.beans.Color.BLACK;
import static xyz.codingmentor.beans.Color.WHITE;
import xyz.codingmentor.beans.Manufacturer;
import static xyz.codingmentor.beans.Manufacturer.HTC;
import xyz.codingmentor.beans.Device;

/**
 *
 * @author Péter
 */
public class DeviceDBTest {

    private static DeviceDB deviceDB;
    private static Device device1;
    private static Device device2;

    private static Manufacturer manufacturer;
    private static String type;
    private static int price;
    private static Color color;
    private static Integer count;

    public DeviceDBTest() {
    }

    @BeforeClass
    public static void init() {
        manufacturer = HTC;
        type = "One";
        price = 30000;
        color = WHITE;
        count = 0;

        device1 = new Device(manufacturer, type, price, color, count);
        color = BLACK;
        device2 = new Device(manufacturer, type, price, color, count);
    }

    @Before
    public void beforeTest() {
        deviceDB = new DeviceDB();
    }

    @Test
    public void testAddDevice() {
        assertEquals(true, deviceDB.getAllDevice().isEmpty());
        assertEquals(device1, deviceDB.addDevice(device1));
        assertEquals(false, deviceDB.getAllDevice().isEmpty());
    }

    @Test
    public void testGetDeviceGood() {
        deviceDB.addDevice(device1);
        deviceDB.addDevice(device2);
        assertEquals(device2, deviceDB.getDevice(device2.getId()));

    }

    @Test(expected = RuntimeException.class)
    public void testGetDeviceBad() {
        deviceDB.addDevice(device1);
        deviceDB.getDevice(device2.getId());

    }

    @Test
    public void testEditDeviceGood() {
        deviceDB.addDevice(device1);
        deviceDB.addDevice(device2);
        assertEquals(device2, deviceDB.editDevice(device2));
    }

    @Test(expected = RuntimeException.class)
    public void testEditDeviceBad() {
        deviceDB.addDevice(device1);
        deviceDB.editDevice(device2);
    }

    @Test
    public void testDeleteDeviceGood() {
        deviceDB.addDevice(device1);
        assertEquals(false, deviceDB.getAllDevice().isEmpty());
        assertEquals(device1, deviceDB.deleteDevice(device1));
        assertEquals(true, deviceDB.getAllDevice().isEmpty());

    }

    @Test(expected = RuntimeException.class)
    public void testDeleteDeviceBad() {
        deviceDB.addDevice(device1);
        assertEquals(false, deviceDB.getAllDevice().isEmpty());
        deviceDB.deleteDevice(device2);
    }

    @Test
    public void testGetAllDevice() {
        deviceDB.addDevice(device1);
        deviceDB.addDevice(device2);
        assertEquals(2, deviceDB.getAllDevice().size());
        assertEquals(true, deviceDB.getAllDevice().contains(device1));
        assertEquals(true, deviceDB.getAllDevice().contains(device2));
    }

}
