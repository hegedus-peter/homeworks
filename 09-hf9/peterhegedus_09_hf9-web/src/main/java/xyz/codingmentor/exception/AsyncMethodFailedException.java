package xyz.codingmentor.exception;

/**
 *
 * @author Péter
 */
public class AsyncMethodFailedException extends RuntimeException {
    
    private static final String ERRORMESSAGE = "Asynchronous method failed: ";

    public AsyncMethodFailedException(String msg) {
        super(ERRORMESSAGE.concat(msg));
    }
}
