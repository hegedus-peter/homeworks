package xyz.codingmentor.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.beans.Device;
import static xyz.codingmentor.beans.Color.WHITE;
import static xyz.codingmentor.beans.Color.BLACK;
import static xyz.codingmentor.beans.Color.GREEN;
import static xyz.codingmentor.beans.Manufacturer.APPLE;
import static xyz.codingmentor.beans.Manufacturer.SAMSUNG;

/**
 *
 * @author Péter
 */
public class DeviceEntityManufacturerValidator implements ConstraintValidator<DeviceEntityManufacturerAnnotation, Device> {

    @Override
    public void initialize(DeviceEntityManufacturerAnnotation device) {
        //Method empty because had to override but not used
    }

    @Override
    public boolean isValid(Device device, ConstraintValidatorContext context) {
        if (null != device.getManufacturer()) {
            if ((device.getManufacturer()).equals(APPLE)) {
                return appleValid(device);
            } else if ((device.getManufacturer()).equals(SAMSUNG)) {
                return samsungValid(device);
            }
            return true;
        }
        return true;
    }

    public boolean appleValid(Device device) {
        if (null != device.getColor()) {
            return (device.getColor()).equals(WHITE) || (device.getColor()).equals(BLACK);
        }
        return true;
    }

    public boolean samsungValid(Device device) {

        if (null != device.getColor()) {
            return !(device.getColor()).equals(GREEN);
        }
        return true;
    }

}
