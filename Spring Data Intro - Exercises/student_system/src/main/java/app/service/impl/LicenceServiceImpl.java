package app.service.impl;

import app.dao.LicenceDao;
import app.model.License;
import app.service.api.LicenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Service
public class LicenceServiceImpl implements LicenceService<License, Long> {
    @Autowired
    private LicenceDao dao;

    @Override
    public License findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(License object) {
        dao.delete(object);
    }

    @Override
    public List<License> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(License object) {
        dao.save(object);
    }
}
