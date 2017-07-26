package app.service.impl;

import app.dao.BasicIngredientDao;
import app.service.api.BasicIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

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

    @Override
    public List<BasicIngredient> findBasicIngredientsByPriceNull() {
        return dao.findBasicIngredientsByPriceNullOrderByNameDescPriceDesc();
    }

    @Override
    public Set<BasicIngredient> findBasicIngredientsByNameStartingWith(String prefix) {
        return dao.findBasicIngredientsByNameStartingWith(prefix);
    }

    @Override
    public List<BasicIngredient> findIngredientsByNames(Set<String> names) {
        return dao.findIngredientsByNames(names);
    }

    @Override
    public void updatePricesInNamesList(List<String> names) {
        dao.updatePricesInNamesList(names);
    }

    @Override
    public void increaseIngredientsPrice() {
        dao.increaseIngredientsPrice();
    }

    @Override
    public List<Object[]>findBySumOfPrice(BigDecimal num) {
        return dao.findBySumOfPrice(num);
    }

    @Override
    public List<Object[]> findNamesAndBrands() {
        return dao.findNamesAndBrands();
    }

    @Override
    public void deleteIgredientByName(String name) {
        dao.deleteIgredientByName(name);
    }


}
