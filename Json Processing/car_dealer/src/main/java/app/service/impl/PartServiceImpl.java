package app.service.impl;

import app.dao.PartDao;
import app.entities.Part;
import app.service.api.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
@Service
public class PartServiceImpl implements PartService<Part, Long> {

    @Autowired
    private PartDao dao;

    @Override
    public Part findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Part object) {
        dao.delete(object);
    }

    @Override
    public List<Part> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Part object) {
        dao.save(object);
    }

    @Override
    public void saveList(List<Part> object) {
        for (Part supplier : object) {
            dao.save(supplier);
        }
    }
}
