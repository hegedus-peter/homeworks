package xyz.codingmentor.exception;

/**
 *
 * @author Péter
 */
public class NotLoggedInException extends RuntimeException {

    private static final String ERRORMESSAGE = "Login required for the requested operation.";

    public NotLoggedInException() {
        super(ERRORMESSAGE);
    }
}
