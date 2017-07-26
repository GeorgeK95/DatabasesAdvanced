package app.dao;

import app.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
public interface CategoryDao  extends JpaRepository<Category, Long> {
}
