package app.transaction;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface Command<E> {
    E execute();
}
