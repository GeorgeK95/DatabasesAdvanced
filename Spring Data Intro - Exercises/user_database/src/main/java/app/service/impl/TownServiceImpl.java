package app.service.impl;

import app.dao.TownDao;
import app.model.Town;
import app.service.api.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Service
public class TownServiceImpl implements TownService<Town, Long> {

    @Autowired
    private TownDao dao;

    @Override
    public Town findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Town object) {
        dao.delete(object);
    }

    @Override
    public List<Town> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Town object) {
        dao.save(object);
    }
}
