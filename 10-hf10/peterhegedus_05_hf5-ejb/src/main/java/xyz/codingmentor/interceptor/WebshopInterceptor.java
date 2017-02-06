package xyz.codingmentor.interceptor;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import xyz.codingmentor.constraint.Interceptable;
import xyz.codingmentor.constraint.Validable;
import xyz.codingmentor.constraint.ValidatorQualifier;
import xyz.codingmentor.exceptions.ValidationException;

/**
 *
 * @author Péter
 */
@Interceptor
@Interceptable
public class WebshopInterceptor {

    @Inject
    @ValidatorQualifier
    private Validator validator;

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        if (!ic.getMethod().isAnnotationPresent(ExcludeClassInterceptors.class) && null != ic.getParameters()) {
            validateParameters(ic.getParameters());
            return ic.proceed();
        }
        return ic.proceed();
    }

    private void validateParameters(Object[] parameters) {
        Arrays.asList(parameters).stream().filter(p -> p.getClass().isAnnotationPresent(Validable.class)).forEach(p -> validateBean(p));
    }

    private void validateBean(Object o) {
        Set<ConstraintViolation<Object>> violations = validator.validate(o);
        Optional<String> errorMessage = violations.stream().map(e -> "Validation error: " + e.getMessage() + " - property: " + e.getPropertyPath().toString() + " . ").reduce(String::concat);
        if (errorMessage.isPresent()) {
            throw new ValidationException(errorMessage.get());
        }
    }

}
