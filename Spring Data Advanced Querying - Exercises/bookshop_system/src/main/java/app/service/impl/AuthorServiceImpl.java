package app.service.impl;

import app.dao.AuthorDao;
import app.domain.Author;
import app.service.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.*;
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
    public List<Author> findAllAuthorsByFirstNameEndsWith(String str) {
        return dao.findAllAuthorsByFirstNameEndsWith(str);
    }

    @Override
    public List<Object[]> totalBooksCopied() {
        return dao.totalBooksCopied();
    }

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Integer booksCountByAuthor(String first, String last) throws SQLException {
        String URL = "jdbc:mysql://localhost:3306/";
        String USER = "root";
        String PASS = "";
        Connection dbConnection = DriverManager.getConnection(URL, USER, PASS);

        String getDBUSERByUserIdSql = "{call booksCount(?,?)}";
        CallableStatement callableStatement = dbConnection.prepareCall(getDBUSERByUserIdSql);
        callableStatement.setString(1, first);
        callableStatement.setString(2, last);

        callableStatement.executeQuery("use bookshopsystem");
        ResultSet resultSet = callableStatement.executeQuery();

        resultSet.next();
        return resultSet.getInt(1);
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
