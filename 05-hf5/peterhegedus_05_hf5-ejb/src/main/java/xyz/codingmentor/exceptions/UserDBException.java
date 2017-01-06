package xyz.codingmentor.exceptions;

/**
 *
 * @author Péter
 */
public class UserDBException extends RuntimeException {

    private static final String ERRORMESSAGE = "This user is not part of the database";

    public UserDBException() {
        super(ERRORMESSAGE);
    }
}
