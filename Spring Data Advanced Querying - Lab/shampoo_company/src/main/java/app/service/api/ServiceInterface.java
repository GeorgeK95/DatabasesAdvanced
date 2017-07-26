package app.service.api;

import java.util.List;

/**
 * Created by George-Lenovo on 7/23/2017.
 */
public interface ServiceInterface<E, K> {
    E findById(K id);

    void remove(E entity);

    List<E> findAll(Class<E> serviceClass);

    void save(E object);
}
