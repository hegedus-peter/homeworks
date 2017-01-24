package xyz.codingmentor.exceptions;

/**
 *
 * @author Péter
 */
public class ShoppingCartNotEnoughDeviceToBuyException extends RuntimeException {

    private static final String ERRORMESSAGE = "Not enough devices to buy: ";

    public ShoppingCartNotEnoughDeviceToBuyException(String data) {
        super(ERRORMESSAGE.concat(data));
    }
}
