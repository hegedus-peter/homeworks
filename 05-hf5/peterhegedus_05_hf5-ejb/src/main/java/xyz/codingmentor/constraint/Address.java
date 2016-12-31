package xyz.codingmentor.constraint;

import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

/**
 *
 * @author Péter
 */
@Constraint(validatedBy = AddressValidator.class)
@ReportAsSingleViolation
@Target({FIELD})
@Retention(RUNTIME)
public @interface Address {
    
    String message() default "{Address.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
