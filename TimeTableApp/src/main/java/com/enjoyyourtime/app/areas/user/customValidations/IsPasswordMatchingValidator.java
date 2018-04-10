package com.enjoyyourtime.app.areas.user.customValidations;

import com.enjoyyourtime.app.areas.user.models.bindingModels.RegistrationModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsPasswordMatchingValidator implements ConstraintValidator<IsPasswordMatching, Object> {
    @Override
    public void initialize(IsPasswordMatching constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object userClass, ConstraintValidatorContext constraintValidatorContext) {
        if(userClass instanceof RegistrationModel){
            return ((RegistrationModel) userClass).getPassword().equals(((RegistrationModel) userClass).getConfirmPassword());
        }

        return false;
    }
}
