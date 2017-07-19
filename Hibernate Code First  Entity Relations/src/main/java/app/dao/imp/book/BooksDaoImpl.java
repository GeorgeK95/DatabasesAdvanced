package app.dao.imp.book;

import app.dao.api.book.BooksDao;
import app.dao.imp.AbstractJpaDao;
import app.domain.book.Author;
import app.domain.book.Book;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
public class BooksDaoImpl extends AbstractJpaDao implements BooksDao {

    @Override
    public Book findByTitle(String id) {
        String findQuery = "select b from Book as b where b.id = :id";
        return (Book) em.createQuery(findQuery).setParameter("id", id).getSingleResult();
    }

    @Override
    public Book findByAuthor(Author author) {
        String findQuery = "select b from Book as b where b.author = :author";
        return (Book) em.createQuery(findQuery).setParameter("author", author).getSingleResult();
    }
}
