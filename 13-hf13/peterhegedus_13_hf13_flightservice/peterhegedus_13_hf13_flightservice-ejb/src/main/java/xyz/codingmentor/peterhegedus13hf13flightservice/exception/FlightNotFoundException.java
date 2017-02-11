package xyz.codingmentor.peterhegedus13hf13flightservice.exception;

/**
 *
 * @author Péter
 */
public class FlightNotFoundException extends RuntimeException {
    
    private static final String ERRORMESSAGE = "Flight not found: ";

    public FlightNotFoundException() {
        //generated
    }

    public FlightNotFoundException(String msg) {
        super(ERRORMESSAGE.concat(msg));
    }
}
