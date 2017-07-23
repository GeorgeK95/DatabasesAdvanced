package app.transaction;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
public interface TransactionSupport<E> {
    void rollback();

    void commit();

    void beginTransaction();

}
