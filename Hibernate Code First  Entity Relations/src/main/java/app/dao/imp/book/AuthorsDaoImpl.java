package app.dao.imp.book;

import app.dao.api.book.AuthorsDao;
import app.dao.imp.AbstractJpaDao;
import app.domain.book.Author;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
public final class AuthorsDaoImpl extends AbstractJpaDao implements AuthorsDao {
    @Override
    public Author findAuthorByFirstName(String firstName) {
        String findQuery = "select a from Author as a where a.firstName = :firstName";
        return (Author) em.createQuery(findQuery).setParameter("firstName", firstName).getSingleResult();
    }

    @Override
    public Author findAuthorByLastName(String lastName) {
        String findQuery = "select a from Author as a where a.lastName = :lastName";
        return (Author) em.createQuery(findQuery).setParameter("lastName", lastName).getSingleResult();
    }
}
