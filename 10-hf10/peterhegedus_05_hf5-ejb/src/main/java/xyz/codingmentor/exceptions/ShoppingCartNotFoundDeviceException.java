package xyz.codingmentor.exceptions;

/**
 *
 * @author Péter
 */
public class ShoppingCartNotFoundDeviceException extends RuntimeException {

    private static final String ERRORMESSAGE = "Device not part of the shopping cart: ";

    public ShoppingCartNotFoundDeviceException(String data) {
        super(ERRORMESSAGE.concat(data));
    }
}
