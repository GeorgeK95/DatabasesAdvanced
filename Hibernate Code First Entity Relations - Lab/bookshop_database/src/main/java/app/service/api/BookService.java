package app.service.api;

import app.domain.Book;

import java.util.List;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface BookService extends Service {
    Book bestSeller();

    List<Book> mostExpensiveBooks(int count);

    Book findBookByTitle(String title);
}
