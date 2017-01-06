package xyz.codingmentor.exceptions;

/**
 *
 * @author Péter
 */
public class DeviceDBException extends RuntimeException {

private static final String ERRORMESSAGE = "This device is not part of the database";

    public DeviceDBException() {
        super(ERRORMESSAGE);
    }
}
