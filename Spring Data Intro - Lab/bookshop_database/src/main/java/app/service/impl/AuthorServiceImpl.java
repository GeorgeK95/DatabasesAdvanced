package app.service.impl;

import app.dao.AuthorsDao;
import app.domain.Author;
import app.service.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Service
public class AuthorServiceImpl implements AuthorService<Author, Long> {
    @Autowired
    private AuthorsDao dao;

    @Override
    public void save(Author entity) {
        dao.save(entity);
    }

    @Override
    public void remove(Author entity) {
        dao.delete(entity);
    }

    @Override
    public List<Author> findAll(Class<Author> authorClass) {
        return dao.findAll();
    }

    @Override
    public Author findById(Long primary) {
        return dao.findOne(primary);
    }

}
