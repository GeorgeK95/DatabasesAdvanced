package app.service.impl;

import app.dao.SaleDao;
import app.entities.Sale;
import app.service.api.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
@Service
public class SaleServiceImpl implements SaleService<Sale, Long> {

    @Autowired
    private SaleDao dao;

    @Override
    public Sale findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Sale object) {
        dao.delete(object);
    }

    @Override
    public List<Sale> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Sale object) {
        dao.save(object);
    }

    @Override
    public void saveList(List<Sale> object) {
        for (Sale sale : object) {
            dao.save(sale);
        }
    }

    @Override
    public List<Object[]> salesWithAppliedDiscount() {
        return dao.salesWithAppliedDiscount();
    }
}
