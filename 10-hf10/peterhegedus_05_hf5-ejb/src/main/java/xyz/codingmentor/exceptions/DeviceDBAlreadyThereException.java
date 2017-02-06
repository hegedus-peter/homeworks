package xyz.codingmentor.exceptions;

/**
 *
 * @author Péter
 */
public class DeviceDBAlreadyThereException extends RuntimeException {

    private static final String ERRORMESSAGE = "This device is already part of the database: ";

    public DeviceDBAlreadyThereException(String data) {
        super(ERRORMESSAGE.concat(data));
    }
}
