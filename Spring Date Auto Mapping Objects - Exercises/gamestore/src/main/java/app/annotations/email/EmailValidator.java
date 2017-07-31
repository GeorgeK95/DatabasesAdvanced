package app.annotations.email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 7/26/2017.
 */
public class EmailValidator implements ConstraintValidator<Email, String> {

    @Override
    public void initialize(Email email) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        //validating email based ot task_9 constraints
        String pattern = "^[a-zA-Z0-9]+([\\.\\-_]*[a-zA-Z0-9]+)*@[a-zA-Z]+(\\.[a-zA-Z]+)+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(email);

        if (!m.matches()) {
            return false;
        }

        return true;
    }
}
