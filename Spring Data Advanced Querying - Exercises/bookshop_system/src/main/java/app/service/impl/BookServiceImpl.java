package app.service.impl;

import app.dao.BookDao;
import app.domain.*;
import app.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public List<Book> findAllBooksByRestriction(AgeRestriction ageRestriction) {
        return dao.findAllBooksByAgeRestriction(ageRestriction);
    }

    @Override
    public List<Book> findGoldTypeBooks(EditionType gold) {
        return dao.findAllBooksByEditionType(gold);
    }

    @Override
    public List<Object[]> findTitlesAndPrice() {
        return dao.findTitlesAndPrice();
    }

    @Override
    public List<Book> findAllBooksByReleaseDateIsNot(Date date) {
        return dao.findAllBooksByReleaseDateIsNot(date);
    }

    @Override
    public List<Book> findAllBooksByCategoriesIn(List<Category> categories) {
        return dao.findAllBooksByCategoriesIn(categories);
    }

    @Override
    public List<Book> findAllBooksByReleaseDateBefore(Date date) {
        return dao.findAllBooksByReleaseDateBefore(date);
    }

    @Override
    public List<Book> findAllBooksByTitleContains(String str) {
        return dao.findAllBooksByTitleContains(str);
    }

    @Override
    public List<Book> findAllBooksByAuthor_LastNameStartsWith(String str) {
        return dao.findAllBooksByAuthor_LastNameStartsWith(str);
    }

    @Override
    public Integer countBooks(Long number) {
        return dao.countBooks(number);
    }

    @Override
    public ReducedBook findAllBooksByTitle(String title) {
        return dao.findAllBooksByTitle(title);
    }

    @Override
    public Integer findAllBooksByReleaseDateAfter(Date date) {
        return dao.findAllBooksByReleaseDateAfter(date);
    }

    @Override
    public void increaseBookCopies(int copiesCount, Date date) {
        dao.increaseBookCopies(copiesCount, date);
    }

    @Override
    public void removeBooksWithLowerCopies(@Param(value = "param") int copiesCount) {
        dao.removeBooksWithLowerCopies(copiesCount);
    }

    @Override
    public Integer findBooksCountWithLowerCopies(@Param(value = "param") int copiesCount) {
        return dao.findBooksCountWithLowerCopies(copiesCount);
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
