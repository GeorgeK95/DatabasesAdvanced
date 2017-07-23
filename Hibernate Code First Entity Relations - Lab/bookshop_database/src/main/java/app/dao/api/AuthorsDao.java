package app.dao.api;

import app.domain.Author;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
public interface AuthorsDao extends Dao {
    Author findAuthorByFirstName(String firstName);

    Author findAuthorByLastName(String lastName);
}
