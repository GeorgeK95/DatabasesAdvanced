package app.service.impl;

import app.dao.BasicIngredientDao;
import app.service.api.BasicIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Service
@Transactional
public class BasicIngredientServiceImpl implements BasicIngredientService<BasicIngredient, Long> {
    @Autowired
    private BasicIngredientDao dao;

    @Override
    public BasicIngredient findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(BasicIngredient entity) {
        dao.delete(entity);
    }

    @Override
    public List<BasicIngredient> findAll(Class<BasicIngredient> serviceClass) {
        return dao.findAll();
    }

    @Override
    public void save(BasicIngredient object) {
        dao.saveAndFlush(object);
    }
}
