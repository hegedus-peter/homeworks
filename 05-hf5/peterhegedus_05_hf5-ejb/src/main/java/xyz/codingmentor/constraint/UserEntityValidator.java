package xyz.codingmentor.constraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import xyz.codingmentor.beans.UserEntity;

/**
 *
 * @author Péter
 */
public class UserEntityValidator implements ConstraintValidator<UserEntityAnnotation, UserEntity>{

    @Override
    public void initialize(UserEntityAnnotation userEntity) {
       //Method empty because had to override but not used 
    }

    @Override
    public boolean isValid(UserEntity userEntity, ConstraintValidatorContext context) {
        return nameValid(userEntity) && dateValid(userEntity);
    }
    
    public boolean nameValid(UserEntity userEntity){
        return null==userEntity.getFirstname() && null==userEntity.getLastname() || 
                null!=userEntity.getFirstname() && null!=userEntity.getLastname();
    }
    
    public boolean dateValid(UserEntity userEntity){
        if(null!=userEntity.getDateOfBirth() && null!= userEntity.getRegistrationDate()){
            return userEntity.getDateOfBirth().before(userEntity.getRegistrationDate());
        }
        return true;
    }

}
