package app.service.impl;

import app.dao.ClassicLabelDao;
import app.domain.impl.ClassicLabel;
import app.service.api.ClassicLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Service
//@Transactional
public class ClassicLabelServiceImpl implements ClassicLabelService<ClassicLabel, Long> {
    @Autowired
    private ClassicLabelDao dao;

    @Override
    public ClassicLabel findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(ClassicLabel entity) {
        dao.delete(entity);
    }

    @Override
    public List<ClassicLabel> findAll(Class<ClassicLabel> serviceClass) {
        return dao.findAll();
    }

    @Override
    public void save(ClassicLabel object) {
        dao.saveAndFlush(object);
    }
}
