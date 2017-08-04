package app.service.api;

import java.util.Set;

/**
 * Created by George-Lenovo on 8/1/2017.
 */
public interface CategoryService<Category, Long> extends ServiceInterface<Category, Long> {
    Set<Object[]> categoriesByProductsCount();
}
