package app.service.impl;

import app.dao.CategoryDao;
import app.entities.Category;
import app.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 8/1/2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService<Category, Long> {

    @Autowired
    private CategoryDao dao;

    @Override
    public Category findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Category object) {
        dao.delete(object);
    }

    @Override
    public List<Category> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Category object) {
        dao.save(object);
    }

    @Override
    public void saveList(List<Category> object) {
        for (Category category : object) {
            dao.save(category);
        }
    }

    @Override
    public Set<Object[]> categoriesByProductsCount() {
        return dao.categoriesByProductsCount();
    }
}
