package app.service.impl;

import app.dao.BasicShampooDao;
import app.domain.impl.ClassicLabel;
import app.domain.impl.ProductionBatch;
import app.domain.impl.Size;
import app.service.api.BasicShampooService;
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
public class BasicShamooServiceImpl implements BasicShampooService<BasicShampoo, Long> {
    @Autowired
    private BasicShampooDao dao;

    @Override
    public BasicShampoo findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(BasicShampoo entity) {
        dao.delete(entity);
    }

    @Override
    public List<BasicShampoo> findAll(Class<BasicShampoo> serviceClass) {
        return dao.findAll();
    }

    @Override
    public void save(BasicShampoo object) {
        dao.saveAndFlush(object);
    }

    @Override
    public List<BasicShampoo> findBasicShampoosByBrand(String brand) {
        return dao.findBasicShampoosByBrand(brand);
    }

    @Override
    public List<BasicShampoo> findBasicShampoosByBrandAndSize(String brand, Size size) {
        return dao.findBasicShampoosByBrandAndSize(brand, size);
    }

    @Override
    public List<BasicShampoo> findBasicShampoosBySizeOrLabel(ClassicLabel label, Size size) {
        return dao.findBasicShampoosBySizeOrLabelOrderByPriceAsc(size, label);
    }

    @Override
    public List<BasicShampoo> findBasicShampoosByPriceAfter(BigDecimal price) {
        return dao.findBasicShampoosByPriceAfterOrderByBrandDesc(price);
    }

    @Override
    public List<BasicShampoo> findBasicShampoosByPriceBefore(BigDecimal price) {
        return dao.findBasicShampoosByPriceBefore(price);
    }

    @Override
    public List<BasicShampoo> findShampoosByLabel(String subTitle) {
        return dao.findShampoosByLabel(subTitle);
    }

    @Override
    public Set<BasicShampoo> findShampoosByIngredients(Set<BasicIngredient> ingredients) {
        return dao.findShampoosByIngredients(ingredients);
    }

    @Override
    public Set<BasicShampoo> findShampoosByIngredientsCount(int count) {
        return dao.findShampoosByIngredientsCount(count);
    }

    @Override
    public Set<BasicShampoo> findBasicShampoosByBatchCount(ProductionBatch batch) {
        return dao.findBasicShampoosByBatch(batch);
    }

    @Override
    public Set<BasicShampoo> findShampoosByIngredientPrice(BigDecimal sumParam) {
        return dao.findShampoosByIngredientPrice(sumParam);
    }

    @Override
    public Set<BasicShampoo> findShampoosWithDifferentLabel(String subTitle, ProductionBatch batch) {
        return dao.findShampoosWithDifferentLabel(subTitle, batch);
    }

    @Override
    public List<Object[]> findBatchDateAndLabelTitle() {
        return dao.findBatchDateAndLabelTitle();
    }

}
