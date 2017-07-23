package app.dao.api;

import app.domain.Category;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
public interface CategoriesDao extends Dao {
    Category findByName(String categoryName);
}
