package xyz.codingmentor.exceptions;

/**
 *
 * @author Péter
 */
public class ShoppingCartNotEnoughDeviceInCartException extends RuntimeException {

    private static final String ERRORMESSAGE = "Not enough devices in cart to remove: ";

    public ShoppingCartNotEnoughDeviceInCartException(String data) {
        super(ERRORMESSAGE.concat(data));
    }
}
