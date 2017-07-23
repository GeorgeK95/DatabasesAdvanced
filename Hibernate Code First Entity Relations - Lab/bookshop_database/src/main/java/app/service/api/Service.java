package app.service.api;

import app.transaction.TransactionExecutor;

import java.util.List;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface Service<E, K> extends TransactionExecutor<E> {
    void save(E entity);

    void remove(E entity);

    List<E> findAll(Class<E> eClass);

    E findById(Class<E> eClass, K primary);
}
