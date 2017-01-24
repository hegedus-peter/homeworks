package xyz.codingmentor.exceptions;

/**
 *
 * @author Péter
 */
public class UserDBAlreadyThereException extends RuntimeException {

    private static final String ERRORMESSAGE = "This user is already part of the database: ";

    public UserDBAlreadyThereException(String data) {
        super(ERRORMESSAGE.concat(data));
    }
}
