package xyz.codingmentor.peterhegedus13hf13flightservice.exception;

/**
 *
 * @author Péter
 */
public class FlightListEmptyException extends RuntimeException {

    private static final String ERRORMESSAGE = "There are no flights in the database.";
    public FlightListEmptyException() {
        super(ERRORMESSAGE);
    }
}
