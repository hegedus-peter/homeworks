package xyz.codingmentor.peterhegedus03hf3confusing.source;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Péter
 */
@Retention(RetentionPolicy.RUNTIME)
    @Target( {
        ElementType.METHOD,
        ElementType.TYPE,
        ElementType.FIELD
    } )
public @interface Confusing {
    
}
