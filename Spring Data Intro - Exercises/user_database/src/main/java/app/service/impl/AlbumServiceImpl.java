package app.service.impl;

import app.dao.AlbumDao;
import app.model.Album;
import app.service.api.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Service
public class AlbumServiceImpl implements AlbumService<Album, Long> {

    @Autowired
    private AlbumDao dao;

    @Override
    public Album findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Album object) {
        dao.delete(object);
    }

    @Override
    public List<Album> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Album object) {
        dao.save(object);
    }
}
