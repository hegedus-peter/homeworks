package xyz.codingmentor.peterhegedus03hf3carfactory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import xyz.codingmentor.peterhegedus03hf3carfactory.sources.Car;
import static xyz.codingmentor.peterhegedus03hf3carfactory.sources.Car.MAZDA;

/**
 *
 * @author Péter
 */

@Retention(RetentionPolicy.RUNTIME)
@Target (ElementType.TYPE)
public @interface BrokenWindowAnnotation{
    Car carType() default MAZDA;
}
