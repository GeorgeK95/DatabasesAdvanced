package app.dao;

import app.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
public interface CategoryDao extends JpaRepository<Category, Long> {
    List<Category> findAllCategoriesByNameIn(List<String> catStrings);

    @Query("select c.name, sum(b.price * b.copies) from Category c inner join c.books b group by c " +
            "order by sum(b.price * b.copies) desc, c.name asc")
    List<Object[]> findProfit();

    @Query("select c from Category c where c.books.size > 35 order by c.books.size desc ")
    List<Category> mostRecentBooks();
}
