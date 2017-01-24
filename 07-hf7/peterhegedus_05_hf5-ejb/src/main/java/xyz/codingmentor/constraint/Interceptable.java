package xyz.codingmentor.constraint;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.interceptor.InterceptorBinding;

/**
 *
 * @author Péter
 */
@InterceptorBinding
@Target(TYPE)
@Retention(RUNTIME)
public @interface Interceptable {

}
