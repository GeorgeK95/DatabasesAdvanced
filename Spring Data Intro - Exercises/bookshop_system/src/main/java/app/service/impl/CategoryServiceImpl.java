package app.service.impl;

import app.dao.CategoryDao;
import app.domain.Category;
import app.service.api.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao dao;

    @Override
    public void save(Category category) {
        dao.save(category);
    }
}
