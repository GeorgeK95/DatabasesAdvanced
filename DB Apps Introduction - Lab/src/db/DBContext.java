package db;

import java.sql.SQLException;

/**
 * Created by George-Lenovo on 7/12/2017.
 */
public interface DBContext {
    <E> boolean persist(E entity) throws SQLException, IllegalAccessException;

    <E> Iterable<E> find(Class<E> table) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException;

    <E> Iterable<E> find(Class<E> table, String where) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException;

    <E> E findFirst(Class<E> table) throws SQLException, IllegalAccessException, InstantiationException;

    <E> E findFirst(Class<E> table, String where) throws SQLException, IllegalAccessException, InstantiationException;

    void closeConn() throws SQLException ;
}
