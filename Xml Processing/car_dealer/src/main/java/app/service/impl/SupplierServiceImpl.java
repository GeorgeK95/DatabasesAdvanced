package app.service.impl;

import app.dao.SupplierDao;
import app.entities.Supplier;
import app.service.api.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
@Service
public class SupplierServiceImpl implements SupplierService<Supplier, Long> {

    @Autowired
    private SupplierDao dao;

    @Override
    public Supplier findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Supplier object) {
        dao.delete(object);
    }

    @Override
    public List<Supplier> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Supplier object) {
        dao.save(object);
    }

    @Override
    public void saveList(List<Supplier> object) {
        for (Supplier supplier : object) {
            dao.save(supplier);
        }
    }

    @Override
    public List<Supplier> findAllSupplierByIsImportedFalse() {
        return dao.findAllSupplierByIsImporterFalse();
    }
}
