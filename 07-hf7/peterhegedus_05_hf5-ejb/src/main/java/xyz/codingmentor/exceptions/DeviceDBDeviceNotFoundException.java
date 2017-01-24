package xyz.codingmentor.exceptions;

/**
 *
 * @author Péter
 */
public class DeviceDBDeviceNotFoundException extends RuntimeException {

    private static final String ERRORMESSAGE = "This device is not part of the database: ";

    public DeviceDBDeviceNotFoundException(String data) {
        super(ERRORMESSAGE.concat(data));
    }
}
