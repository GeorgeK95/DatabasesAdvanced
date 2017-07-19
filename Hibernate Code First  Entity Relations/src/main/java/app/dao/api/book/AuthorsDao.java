package app.dao.api.book;

import app.domain.book.Author;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
public interface AuthorsDao extends Dao {
    Author findAuthorByFirstName(String firstName);

    Author findAuthorByLastName(String lastName);
}
