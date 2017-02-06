package xyz.codingmentor.constraint;

import static java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Péter
 */
@Size(min = 6)
@NotNull
@Pattern.List({
    @Pattern(regexp = ".*[a-z].*")
    ,
    @Pattern(regexp = ".*[A-Z].*")
    ,
    @Pattern(regexp = ".*[0-9|=|+|<|>|.|,].*")
})
@Constraint(validatedBy = {})
@ReportAsSingleViolation
@Target({FIELD})
@Retention(RUNTIME)
public @interface Password {

    String message() default "{Password.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
