package app.dao.api.book;

import app.transaction.TransactionSupport;

import java.util.List;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
public interface Dao<E, K> extends TransactionSupport<E> {
    void save(E entity);

    void remove(E entity);

    List<E> findAll(Class<E> eClass);

    E findById(Class<E> eClass, K primary);
}
