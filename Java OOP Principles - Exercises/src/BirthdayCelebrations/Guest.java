package BirthdayCelebrations;

import java.util.Date;

/**
 * Created by George-Lenovo on 7/5/2017.
 */
public interface Guest {
    String getNameOrModel();

    int getAge();

    String getId();

    String getBirthdate();

    boolean isFake(String id);

    boolean compareYear(String yearParam);

    String getType();
}
