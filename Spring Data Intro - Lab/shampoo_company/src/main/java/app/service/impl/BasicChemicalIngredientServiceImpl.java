package app.service.impl;

import app.dao.BasicChemicalIngredientDao;
import app.domain.impl.BasicChemicalIngredient;
import app.service.api.BasicChemicalIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by George-Lenovo on 7/23/2017.
 */
@Service
@Transactional
public class BasicChemicalIngredientServiceImpl implements BasicChemicalIngredientService<BasicChemicalIngredient, Long> {

    @Autowired
    private final BasicChemicalIngredientDao dao;

    public BasicChemicalIngredientServiceImpl(BasicChemicalIngredientDao dao) {
        this.dao = dao;
    }

    @Override
    public BasicChemicalIngredient findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(BasicChemicalIngredient entity) {
        dao.delete(entity);
    }

    @Override
    public List<BasicChemicalIngredient> findAll(Class<BasicChemicalIngredient> serviceClass) {
        return dao.findAll();
    }

    @Override
    public void save(BasicChemicalIngredient object) {
        dao.saveAndFlush(object);
    }

}
