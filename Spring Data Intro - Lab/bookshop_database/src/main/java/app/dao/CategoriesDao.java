package app.dao;

import app.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
@Transactional
@Repository
public interface CategoriesDao extends JpaRepository<Category, Long> {
    Category findByName(String categoryName);
}
