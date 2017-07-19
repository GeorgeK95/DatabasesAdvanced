package app.dao.api.book;

import app.domain.book.Category;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
public interface CategoriesDao extends Dao {
    Category findByName(String categoryName);
}
