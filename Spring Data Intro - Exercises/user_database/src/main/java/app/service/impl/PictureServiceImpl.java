package app.service.impl;

import app.dao.PictureDao;
import app.model.Picture;
import app.service.api.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Service
public class PictureServiceImpl implements PictureService<Picture, Long> {

    @Autowired
    private PictureDao dao;

    @Override
    public Picture findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Picture object) {
        dao.delete(object);
    }

    @Override
    public List<Picture> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Picture object) {
        dao.save(object);
    }
}
