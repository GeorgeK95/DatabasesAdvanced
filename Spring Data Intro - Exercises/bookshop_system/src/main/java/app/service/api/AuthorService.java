package app.service.api;

import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
public interface AuthorService<Author, Long> extends ServiceInterface<Author, Long> {
    List<Author> findAllAuthorsWithAtLeastOneBookAfter1990();
}
