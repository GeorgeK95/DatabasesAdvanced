package app.service.impl;

import app.dao.BookDao;
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
    private BookDao dao;

    @Override
    public void save(Book entity) {
        dao.save(entity);
    }

    public List<String> findBooksAfter2000() {
        return dao.findBooksAfter2000();
    }

    @Override
    public List<Book> findAllBooksByGeorgePowell() {
        return dao.findAllBooksByGeorgePowell();
    }


    @Override
    public Book findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Book object) {
        dao.delete(object);
    }

    @Override
    public List findAll() {
        return dao.findAll();
    }


}
