package xyz.codingmentor.beans;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;
import static xyz.codingmentor.beans.Manufacturer.HTC;
import static xyz.codingmentor.beans.Color.WHITE;
import static xyz.codingmentor.beans.Color.GREEN;
import static xyz.codingmentor.beans.Manufacturer.APPLE;
import static xyz.codingmentor.beans.Manufacturer.SAMSUNG;

/**
 *
 * @author Péter
 */
public class DeviceTest {

    private static ValidatorFactory vf;
    private static Validator validator;

    private static Manufacturer manufacturer;
    private static String type;
    private static int price;
    private static Color color;
    private static Integer count;

    public DeviceTest() {
    }

    @BeforeClass
    public static void init() {
        vf = Validation.buildDefaultValidatorFactory();
        validator = vf.getValidator();

        manufacturer = HTC;
        type = "One";
        price = 30000;
        color = WHITE;
        count = 5;
    }

    @Test
    public void shouldRaiseNoConstraintViolation() {

        Device device = new Device(manufacturer, type, price, color, count);

        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(0, violations.size());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseManufacturerNull() {

        Device device = new Device(null, type, price, color, count);

        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseTypeNull() {

        Device device = new Device(manufacturer, null, price, color, count);

        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseTypeWrong() {

        String wrongType = "s";
        Device device = new Device(manufacturer, wrongType, price, color, count);

        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongType, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void shouldRaiseConstraintViolationCausePriceNull() {

        Device device = new Device(manufacturer, type, null, color, count);

        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void shouldRaiseConstraintViolationCausePriceWrong() {

        Integer wrongPrice = -1;
        Device device = new Device(manufacturer, type, wrongPrice, color, count);

        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongPrice, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseColorNull() {

        Device device = new Device(manufacturer, type, price, null, count);

        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseCountNull() {
        Manufacturer apple = APPLE;
        Device device = new Device(apple, type, price, color, null);

        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseAppleColor() {
        Color wrongColor = GREEN;
        Manufacturer apple = APPLE;
        Device device = new Device(apple, type, price, wrongColor, count);

        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(device, violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{DeviceEntityManufacturer.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseSamsugColor() {
        Color wrongColor = GREEN;
        Manufacturer samsung = SAMSUNG;
        Device device = new Device(samsung, type, price, wrongColor, count);

        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(device, violations.iterator().next().getInvalidValue());
        Assert.assertEquals("{DeviceEntityManufacturer.message}", violations.iterator().next().getMessageTemplate());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseIdNull() {
        Device device = new Device(manufacturer, type, price, color, count);
        device.setId(null);

        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(null, violations.iterator().next().getInvalidValue());
    }

    @Test
    public void shouldRaiseConstraintViolationCauseIdWrong() {
        Device device = new Device(manufacturer, type, price, color, count);
        String wrongId = "wrong";
        device.setId(wrongId);

        Set<ConstraintViolation<Device>> violations = validator.validate(device);
        Assert.assertEquals(1, violations.size());
        Assert.assertEquals(wrongId, violations.iterator().next().getInvalidValue());
    }

}
