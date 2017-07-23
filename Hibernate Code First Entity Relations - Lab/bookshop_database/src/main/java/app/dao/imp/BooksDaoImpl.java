package app.dao.imp;

import app.dao.api.BooksDao;
import app.domain.Author;
import app.domain.Book;

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
