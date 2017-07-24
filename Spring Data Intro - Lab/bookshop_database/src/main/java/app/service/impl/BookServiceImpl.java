package app.service.impl;

import app.dao.BooksDao;
import app.domain.Book;
import app.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Service
public class BookServiceImpl implements BookService<Book, Long> {
    @Autowired
    private BooksDao dao;

    @Override
    public void save(Book entity) {
        dao.save(entity);
    }

    @Override
    public void remove(Book entity) {
        dao.delete(entity);
    }

    @Override
    public List<Book> findAll(Class<Book> bookClass) {
        return dao.findAll();
    }

    @Override
    public Book findById(Long primary) {
        return dao.findOne(primary);
    }
}
