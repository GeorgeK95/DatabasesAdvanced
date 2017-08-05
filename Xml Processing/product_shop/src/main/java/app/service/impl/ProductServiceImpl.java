package app.service.impl;

import app.dao.ProductDao;
import app.entities.Product;
import app.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 8/1/2017.
 */
@Service
public class ProductServiceImpl implements ProductService<Product, Long> {

    @Autowired
    private ProductDao dao;

    @Override
    public Product findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Product object) {
        dao.delete(object);
    }

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Product object) {
        dao.save(object);
    }

    @Override
    public void saveList(List<Product> object) {
        for (Product product : object) {
            dao.save(product);
        }
    }

    @Override
    public Set<Object[]> productsInRange() {
        return dao.productsInRange();
    }
}
