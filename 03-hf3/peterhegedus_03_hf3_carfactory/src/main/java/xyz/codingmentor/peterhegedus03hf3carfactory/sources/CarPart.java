package xyz.codingmentor.peterhegedus03hf3carfactory.sources;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.peterhegedus03hf3carfactory.annotation.BrokenWindowAnnotation;
import xyz.codingmentor.peterhegedus03hf3carfactory.annotation.Quality;
import static xyz.codingmentor.peterhegedus03hf3carfactory.annotation.Quality.GOOD;
import static xyz.codingmentor.peterhegedus03hf3carfactory.annotation.Quality.WRONG;
import xyz.codingmentor.peterhegedus03hf3carfactory.annotation.WrappingAnnotation;

/**
 *
 * @author Péter
 */
public abstract class CarPart {

    protected String manufacturer;
    protected Quality quality;
    protected Car carType;
    @WrappingAnnotation
    protected boolean isWrapped;
    protected static final Logger LOG = Logger.getAnonymousLogger();

    public CarPart(Car carType, String manufacturer) {
        this.manufacturer = manufacturer;
        this.carType = carType;
        this.quality = GOOD;
        this.isWrapped = true;
    }

    public void seriesError() {
        for (Field field : this.getClass().getDeclaredFields()) {
            if (null != field.getAnnotations()) {
                makeFieldError(field.getDeclaredAnnotations());
            }
        }
        if (null != this.getClass().getAnnotations()) {
            makeClassError(this.getClass().getAnnotations());
        }
    }

    public void makeClassError(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(BrokenWindowAnnotation.class)
                    && ((BrokenWindowAnnotation) annotation).carType() == this.carType
                    && Calendar.getInstance().getTimeInMillis() % 2 == 0) {
                this.quality = WRONG;
            }
        }
    }

    public void makeFieldError(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(WrappingAnnotation.class)
                    && ((WrappingAnnotation) annotation).carType() == this.carType
                    && Calendar.getInstance().getTimeInMillis() % 2 == 0) {

                this.quality = WRONG;

            }
        }
    }

    public void listErrors() {
        if (0 != this.getClass().getAnnotations().length) {
            LOG.log(Level.INFO, "Possible class errors: {0}", Arrays.toString(this.getClass().getAnnotations()));
        }
        for (Field field : this.getClass().getSuperclass().getDeclaredFields()) {
            if (0 != field.getAnnotations().length) {
                LOG.log(Level.INFO, "Possible inherited field errors: {0}", Arrays.toString(field.getAnnotations()));
            }
        }
        for (Field field : this.getClass().getDeclaredFields()) {
            if (0 != field.getAnnotations().length) {
                LOG.log(Level.INFO, "Possible field errors: {0}", Arrays.toString(field.getAnnotations()));
            }
        }
        LOG.log(Level.INFO, "This part''s quality: {0}", this.quality);
    }
}
