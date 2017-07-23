package app.service.api;

import app.domain.Author;
import app.domain.Book;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface AuthorService<E, K> extends Service {
    Book bestSeller(Author author);

    Author findByName(String name);

    Author findByName(String fName, String lName);
}
