package app.dao.api.book;

import app.domain.book.Author;
import app.domain.book.Book;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
public interface BooksDao extends Dao {
    Book findByTitle(String id);

    Book findByAuthor(Author author);
}
