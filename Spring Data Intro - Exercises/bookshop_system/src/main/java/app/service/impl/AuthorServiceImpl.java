package app.service.impl;

import app.dao.AuthorDao;
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
    private AuthorDao dao;


    @Override
    public List<Author> findAllAuthorsWithAtLeastOneBookAfter1990() {
        return dao.findAllAuthorsWithAtLeastOneBookAfter1990();
    }

    @Override
    public Author findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Author object) {
        dao.delete(object);
    }

    @Override
    public List<Author> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Author object) {
        dao.save(object);
    }
}
