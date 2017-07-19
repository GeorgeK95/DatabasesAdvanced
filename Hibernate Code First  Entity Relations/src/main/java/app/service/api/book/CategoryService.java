package app.service.api.book;

import app.domain.book.Book;
import app.domain.book.Category;

import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface CategoryService extends Service {
    Category findByName(String name);

    Set<Book> getCategoryBooks(Category category);
}
