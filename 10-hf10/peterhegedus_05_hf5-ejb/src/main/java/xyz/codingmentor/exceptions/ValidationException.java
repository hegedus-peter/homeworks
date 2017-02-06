package xyz.codingmentor.exceptions;

/**
 *
 * @author Péter
 */
public class ValidationException extends RuntimeException {

    public ValidationException(String msg) {
        super(msg);
    }

    public ValidationException() {
        super();
    }

}
