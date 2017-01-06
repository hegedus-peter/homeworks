package xyz.codingmentor.exceptions;

/**
 *
 * @author Péter
 */
public class DeviceDBNotFoundException extends RuntimeException {
    
    private static final String ERRORMESSAGE = "This device is not part of the database: ";
    
    public DeviceDBNotFoundException(String data) {
        super(ERRORMESSAGE.concat(data));
    }
}
