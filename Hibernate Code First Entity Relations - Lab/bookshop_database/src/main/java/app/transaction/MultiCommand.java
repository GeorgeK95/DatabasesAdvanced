package app.transaction;

import java.util.List;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface MultiCommand<E> {
    List<E> execute();
}
