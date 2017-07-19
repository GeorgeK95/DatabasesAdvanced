package app.dao.imp.book;

import app.dao.api.book.CategoriesDao;
import app.dao.imp.AbstractJpaDao;
import app.domain.book.Category;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
public class CategoriesDaoImpl extends AbstractJpaDao implements CategoriesDao {

    @Override
    public Category findByName(String categoryName) {
        String findQuery = "select c from Category as c where c.name = :categoryName";
        return (Category) em.createQuery(findQuery).setParameter("categoryName", categoryName).getSingleResult();
    }
}
