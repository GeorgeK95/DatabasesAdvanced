package app.service.impl;

import app.dao.CategoryDao;
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
    public List findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Category object) {
        dao.save(object);
    }

    @Override
    public List<Category> findAllCategoriesByName(List<String> catStrings) {
        return dao.findAllCategoriesByNameIn(catStrings);
    }

    @Override
    public List<Object[]> findProfit() {
        return dao.findProfit();
    }

    @Override
    public List<Category> mostRecentBooks() {
        return dao.mostRecentBooks();
    }
}
