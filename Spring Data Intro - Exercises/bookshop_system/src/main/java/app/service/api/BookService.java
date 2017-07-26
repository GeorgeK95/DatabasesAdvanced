package app.service.api;

import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
public interface BookService<Book, Long> extends ServiceInterface<Book, Long> {
    List<String> findBooksAfter2000();

    List<Book> findAllBooksByGeorgePowell();
}
