package app.annotations.password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George-Lenovo on 7/26/2017.
 */
public class PasswordValidator implements ConstraintValidator<Password, String> {

    int minLength;

    int maxLength;

    boolean containLowerCaseLetter;

    boolean containUpperCaseLetter;

    boolean containDigit;

    boolean containSymbol;

    @Override
    public void initialize(Password password) {
        this.minLength = password.minLength();
        this.maxLength = password.maxLength();
        this.containLowerCaseLetter = password.containLowerCaseLetter();
        this.containUpperCaseLetter = password.containUpperCaseLetter();
        this.containDigit = password.containDigit();
        this.containSymbol = password.containSymbol();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        //validating password based ot task_9 constraints
        boolean containLowerCaseLetter = checkForLowerCaseLetter(password);
        boolean containUpperCaseLetter = checkForUpperCaseLetter(password);
        boolean containDigit = checkForDigit(password);
        boolean containSymbol = checkForSpecialSymbol(password);
        int lenght = password.length();

        if (lenght <= 6 || (!containLowerCaseLetter && this.containLowerCaseLetter) || (!containUpperCaseLetter && this.containUpperCaseLetter) || (!containDigit && this.containDigit)/* || (!containSymbol && this.containSymbol)*/) {
            return false;
        }

        return true;
    }

    private boolean checkForSpecialSymbol(String password) {
        List<Character> arr = new ArrayList<Character>() {{
            add('!');
            add('@');
            add('#');
            add('$');
            add('%');
            add('^');
            add('&');
            add('*');
            add('(');
            add(')');
            add('_');
            add('+');
            add('<');
            add('>');
            add('?');
            add('(');
            add(')');
        }};

        for (char c : password.toCharArray()) {
            if (arr.contains(c)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForDigit(String password) {
        for (char c : password.toCharArray()) {
            int cc = (int) c;
            if (cc >= 48 && cc <= 57) {
                return true;
            }
        }

        return false;
    }

    private boolean checkForUpperCaseLetter(String password) {
        for (char c : password.toCharArray()) {
            int cc = (int) c;
            if (cc >= 65 && cc <= 90) {
                return true;
            }
        }

        return false;
    }

    private boolean checkForLowerCaseLetter(String password) {
        for (char c : password.toCharArray()) {
            int cc = (int) c;
            if (cc >= 97 && cc <= 122) {
                return true;
            }
        }

        return false;
    }
}
