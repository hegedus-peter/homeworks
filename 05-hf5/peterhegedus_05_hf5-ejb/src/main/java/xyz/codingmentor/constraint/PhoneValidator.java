package xyz.codingmentor.constraint;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Péter
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private final Pattern phonePattern = Pattern.compile("^[0][6]\\d{9}");
    private final Pattern phonePattern2 = Pattern.compile("^[+][3][6]\\d{9}");
    
    @Override
    public void initialize(Phone phone) {
     //Method empty because had to override but not used
    }

    @Override
    public boolean isValid(String phone, ConstraintValidatorContext context) {
       if(null==phone){
           return true;
       }
       Matcher m = phonePattern.matcher(phone);
       Matcher m2= phonePattern2.matcher(phone);
       
       return m.matches() || m2.matches();
    }

}
