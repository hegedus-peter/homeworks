package xyz.codingmentor.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.beans.UserEntity;

/**
 *
 * @author Péter
 */
public class UserEntityNameValidator implements ConstraintValidator<UserEntityNameAnnotation, UserEntity> {

    @Override
    public void initialize(UserEntityNameAnnotation userEntity) {
        //Method empty because had to override but not used 
    }

    @Override
    public boolean isValid(UserEntity userEntity, ConstraintValidatorContext context) {
        return null == userEntity.getFirstname() && null == userEntity.getLastname()
                || null != userEntity.getFirstname() && null != userEntity.getLastname();
    }

}
