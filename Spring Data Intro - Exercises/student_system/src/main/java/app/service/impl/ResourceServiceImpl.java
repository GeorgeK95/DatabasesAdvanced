package app.service.impl;

import app.dao.ResourceDao;
import app.model.Resource;
import app.service.api.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Service
public class ResourceServiceImpl implements ResourceService<Resource, Long> {

    @Autowired
    private ResourceDao dao;

    @Override
    public Resource findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Resource object) {
        dao.delete(object);
    }

    @Override
    public List<Resource> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Resource object) {
        dao.save(object);
    }
}
