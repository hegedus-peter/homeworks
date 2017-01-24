package xyz.codingmentor.constraint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Péter
 */
public class AddressValidator implements ConstraintValidator<Address, String> {

    private final Pattern addressPattern = Pattern.compile("^\\d{4}.*");

    @Override
    public void initialize(Address adress) {
        //Method empty because had to override but not used
    }

    @Override
    public boolean isValid(String address, ConstraintValidatorContext context) {
        if (null == address) {
            return true;
        }
        Matcher m = addressPattern.matcher(address);

        return m.matches();
    }

}
