package app.service.impl;

import app.dao.ProductionBatchDao;
import app.domain.impl.ProductionBatch;
import app.service.api.ProductionBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by George-Lenovo on 7/23/2017.
 */
@Service
@Transactional
public class ProductionBatchServiceImpl implements ProductionBatchService<ProductionBatch, Long> {
    @Autowired
    private final ProductionBatchDao dao;

    @Autowired
    public ProductionBatchServiceImpl(ProductionBatchDao dao) {
        this.dao = dao;
    }

    @Override
    public ProductionBatch findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(ProductionBatch entity) {
        dao.delete(entity);
    }

    @Override
    public List<ProductionBatch> findAll(Class<ProductionBatch> serviceClass) {
        return dao.findAll();
    }

    @Override
    public void save(ProductionBatch object) {
        dao.saveAndFlush(object);
    }

    @Override
    public List<ProductionBatch> findBatchByName(String name) {
        return ((ProductionBatchDao) dao).findByName(name);
    }
}
