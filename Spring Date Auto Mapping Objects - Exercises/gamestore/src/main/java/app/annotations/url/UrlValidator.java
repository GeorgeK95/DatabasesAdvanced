package app.annotations.url;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public class UrlValidator implements ConstraintValidator<Url, String> {

//    String videoId;

    @Override
    public void initialize(Url url) {
        /*this.videoId = url.getUrl();*/
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.startsWith("http://") || s.startsWith("https://") || s.equals("")) {
            return true;
        }
        return false;
    }
}
