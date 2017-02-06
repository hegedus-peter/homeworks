package xyz.codingmentor.producer;

import javax.enterprise.inject.Produces;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import xyz.codingmentor.constraint.ValidatorQualifier;

/**
 *
 * @author Péter
 */
public class ValidatorProducer {

    @Produces
    @ValidatorQualifier
    public Validator produceLogger() {
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        return vf.getValidator();
    }

}
