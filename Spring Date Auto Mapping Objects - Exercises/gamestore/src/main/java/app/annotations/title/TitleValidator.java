package app.annotations.title;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by George-Lenovo on 7/26/2017.
 */
public class TitleValidator implements ConstraintValidator<Title, String> {

    int minLength;

    int maxLength;

    boolean startsWithUpperCaseLetter;

    @Override
    public void initialize(Title title) {
        this.minLength = title.minLength();
        this.maxLength = title.maxLength();
        this.startsWithUpperCaseLetter = title.startsWithUpperCase();
    }

    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {
        int length = title.length();

        if (length < minLength || length > maxLength || !startsWithUpper(title)) {
            return false;
        }

        return true;
    }

    private boolean startsWithUpper(String title) {
        char firstLetter = title.charAt(0);
        if (firstLetter < 65 || firstLetter > 90) {
            return false;
        }
        return true;
    }
}
