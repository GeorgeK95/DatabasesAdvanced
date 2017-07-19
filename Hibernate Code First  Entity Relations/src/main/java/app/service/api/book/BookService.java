package app.service.api.book;

import app.domain.book.Book;

import java.util.List;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface BookService extends Service {
    Book bestSeller();

    List<Book> mostExpensiveBooks(int count);

    Book findBookByTitle(String title);
}
