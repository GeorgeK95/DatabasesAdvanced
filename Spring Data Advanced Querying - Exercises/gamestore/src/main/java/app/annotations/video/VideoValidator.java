package app.annotations.video;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public class VideoValidator implements ConstraintValidator<Video, String> {
//    String videoId;

    @Override
    public void initialize(Video video) {
        /*this.videoId = video.getVideoId();*/
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s.length() != 11) {
            return false;
        }
        return true;
    }

  /*  private boolean isValidId(String s) {
        String youtube = "https://www.youtube.com/watch?v=";
        if (!s.startsWith(youtube)) {
            return false;
        }

        s = s.replaceFirst(youtube, "");

        if (s.length() != 11) {
            return false;
        }

        return true;
    }*/
}
