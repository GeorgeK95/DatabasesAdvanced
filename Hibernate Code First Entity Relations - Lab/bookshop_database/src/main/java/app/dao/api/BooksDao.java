package app.dao.api;

import app.domain.Author;
import app.domain.Book;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
public interface BooksDao extends Dao {
    Book findByTitle(String id);

    Book findByAuthor(Author author);
}
