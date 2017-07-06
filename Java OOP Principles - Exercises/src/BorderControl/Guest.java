package BorderControl;

/**
 * Created by George-Lenovo on 7/5/2017.
 */
public interface Guest {
    String getNameOrModel();

    int getAge();

    String getId();

    boolean isFake(String id);

}
