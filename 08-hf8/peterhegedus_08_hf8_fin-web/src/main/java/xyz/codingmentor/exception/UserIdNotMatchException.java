package xyz.codingmentor.exception;

/**
 *
 * @author Péter
 */
public class UserIdNotMatchException extends RuntimeException {

    public UserIdNotMatchException() {
        super();
    }

    public UserIdNotMatchException(String msg) {
        super(msg);
    }

}
