package app.services.api;

import java.util.List;

public interface ServiceInterface<E, K> {

    E findById(K id);

    List<E> findAll();

    void save(E object);

}