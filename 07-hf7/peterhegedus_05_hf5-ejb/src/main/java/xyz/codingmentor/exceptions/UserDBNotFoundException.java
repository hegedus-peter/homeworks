package xyz.codingmentor.exceptions;

/**
 *
 * @author Péter
 */
public class UserDBNotFoundException extends RuntimeException {

    private static final String ERRORMESSAGE = "This user is not part of the database: ";

    public UserDBNotFoundException(String data) {
        super(ERRORMESSAGE.concat(data));
    }
}
