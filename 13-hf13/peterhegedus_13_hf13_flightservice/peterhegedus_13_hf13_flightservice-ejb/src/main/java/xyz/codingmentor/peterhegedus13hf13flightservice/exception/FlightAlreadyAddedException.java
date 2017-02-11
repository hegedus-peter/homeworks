package xyz.codingmentor.peterhegedus13hf13flightservice.exception;

/**
 *
 * @author Péter
 */
public class FlightAlreadyAddedException extends RuntimeException {
    
    private static final String ERRORMESSAGE = "Flight already added: ";

    public FlightAlreadyAddedException() {
        //generated
    }

    public FlightAlreadyAddedException(String msg) {
        super(ERRORMESSAGE.concat(msg));
    }
}
