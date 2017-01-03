/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Constraint(validatedBy = UserEntityNameValidator.class)
public @interface UserEntityNameAnnotation {
    
    String message() default "{UserEntityName.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
