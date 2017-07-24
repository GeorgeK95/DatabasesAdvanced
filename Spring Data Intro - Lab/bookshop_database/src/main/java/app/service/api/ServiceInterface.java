package app.service.api;

import java.util.List;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface ServiceInterface<E, K> {
    void save(E entity);

    void remove(E entity);

    List<E> findAll(Class<E> eClass);

    E findById(K primary);
}
