package app.annotations.description;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public class DescriptionValidator implements ConstraintValidator<Description, String> {
    @Override
    public void initialize(Description description) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.length() >= 20;
    }
}
