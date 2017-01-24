package xyz.codingmentor.exception;

/**
 *
 * @author Péter
 */
public class UserNotFoundException extends RuntimeException {
    
    private static final String ERRORMESSAGE = "User not found: ";

    public UserNotFoundException(String msg) {
        super(ERRORMESSAGE.concat(msg));
    }
}
