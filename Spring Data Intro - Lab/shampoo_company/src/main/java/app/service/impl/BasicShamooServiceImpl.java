package app.service.impl;

import app.dao.BasicShampooDao;
import app.service.api.BasicShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
}
