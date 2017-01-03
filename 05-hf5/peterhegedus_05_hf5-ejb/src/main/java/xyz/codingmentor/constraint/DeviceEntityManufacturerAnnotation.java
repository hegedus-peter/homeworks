package xyz.codingmentor.constraint;

import static java.lang.annotation.ElementType.TYPE;
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
@ReportAsSingleViolation
@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = DeviceEntityManufacturerValidator.class)
public @interface DeviceEntityManufacturerAnnotation {
    
    String message() default "{DeviceEntityManufacturer.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
}
