package app.service.impl;

import app.dao.CategoriesDao;
import app.domain.Category;
import app.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService<Category, Long> {
    @Autowired
    private CategoriesDao dao;

    @Override
    public void save(Category entity) {
        dao.save(entity);
    }

    @Override
    public void remove(Category entity) {
        dao.delete(entity);
    }

    @Override
    public List<Category> findAll(Class<Category> categoryClass) {
        return dao.findAll();
    }

    @Override
    public Category findById(Long primary) {
        return dao.findOne(primary);
    }
}
