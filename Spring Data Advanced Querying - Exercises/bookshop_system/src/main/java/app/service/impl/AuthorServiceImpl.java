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
//        jdbc:mysql://localhost:3306/bookshopsystem?useSSL=false
        String URL = "jdbc:mysql://localhost:3306/";
        String USER = "root";
        String PASS = "";
        Connection dbConnection = DriverManager.getConnection(URL, USER, PASS);
        CallableStatement callableStatement = dbConnection.prepareCall("{call booksCount(?,?)}");
        CallableStatement useState = dbConnection.prepareCall("use bookshopsystem");
        String getDBUSERByUserIdSql = "{call booksCount(?,?)}";
        callableStatement = dbConnection.prepareCall(getDBUSERByUserIdSql);
//        callableStatement.setInt(1, 10);
        callableStatement.setString(1, "bai ti");
        callableStatement.setString(2, "pesho");
//        callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
//        callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
//        callableStatement.registerOutParameter(4, java.sql.Types.DATE);

// execute getDBUSERByUserId store procedure
        useState.execute();
        ResultSet rs = callableStatement.getResultSet();//executeUpdate();
        int res = callableStatement.getInt(1);
        return res;
//        String userName = callableStatement.getString(2);
//        String createdBy = callableStatement.getString(3);
//        Date createdDate = callableStatement.getDate(4);


//        Query query1 = session.getNamedQuery("callStockStoreProcedure")
//                .setParameter("stockCode", "7277");
//
//        Query query = entityManager.createNamedQuery("yourInternalName");
//        query.setParameter("param1", first);
//        query.setParameter("param2", last);
//        return (Integer) query.getSingleResult();
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
