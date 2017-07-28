package app.service.api;

import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
public interface CategoryService<Category, Long> extends ServiceInterface<Category, Long> {
    List<app.domain.Category> findAllCategoriesByName(List<String> catStrings);
    List<Object[]> findProfit();
    List<Category> mostRecentBooks();
}
