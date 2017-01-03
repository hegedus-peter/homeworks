package xyz.codingmentor.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.beans.UserEntity;

/**
 *
 * @author Péter
 */
public class UserEntityDateValidator implements ConstraintValidator<UserEntityDateAnnotation, UserEntity>{

    @Override
    public void initialize(UserEntityDateAnnotation userEntity) {
       //Method empty because had to override but not used 
    }

    @Override
    public boolean isValid(UserEntity userEntity, ConstraintValidatorContext context) {
        if(null!=userEntity.getDateOfBirth() && null!= userEntity.getRegistrationDate()){
            return userEntity.getDateOfBirth().before(userEntity.getRegistrationDate());
        }
        return true;
    }
   
}
