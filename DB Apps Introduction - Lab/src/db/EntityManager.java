package db;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by George-Lenovo on 7/12/2017.
 */
public class EntityManager implements DBContext {

    private Connection connection;
    private HashSet<Object> persistedEntities;

    public void closeConn() throws SQLException {
        this.connection.close();
    }

    public EntityManager(Connection connection) {
        this.connection = connection;
        this.persistedEntities = new HashSet<>();
    }

    private <E> boolean doCreate(E entity, Field primary) throws SQLException, IllegalAccessException {
        try (Statement statement = connection.createStatement()) {
            String q = "CREATE TABLE IF NOT EXISTS " + entity.getClass().getSimpleName().toLowerCase() + " ( ";
            Field[] fields = entity.getClass().getDeclaredFields();

            int n = fields.length;
            for (int i = 0; i < n; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                String name = field.getName();
                q += name + " " + getDBType(primary, field);

                if (i != n - 1) {
                    q += ", ";
                }

            }

            q += ")";
            statement.execute(q);
        }

        return true;
    }

    private String getDBType(Field primary, Field field) {
        field.setAccessible(true);

        if (field.getType().getSimpleName().equals(primary.getType().getSimpleName())) {
            return "INT AUTO_INCREMENT PRIMARY KEY";
        }

        switch (field.getType().getSimpleName()) {
            case "int":
                return "INT";
            case "String":
                return "VARCHAR(20)";
            case "LocalDate":
                return "DATE";
        }

        return null;
    }

    @Override
    public <E> boolean persist(E entity) throws SQLException, IllegalAccessException {
        Field primary = this.getId(entity.getClass());
        primary.setAccessible(true);
        Object val = primary.get(entity);

        this.doCreate(entity, primary);

        if (val == null || (long) val <= 0) {
            return this.insert(entity, primary);
        }

        return this.update(entity, primary);
    }

    private <E> boolean update(E entity, Field primary) throws SQLException, IllegalAccessException {
        String updateQuery = "UPDATE " + this.getTableName(entity.getClass()) + " SET ";
        String whereQuery = " WHERE ";

        Field[] fields = entity.getClass().getDeclaredFields();

        int n = fields.length;
        for (int i = 0; i < n; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            String name = field.getName();
            Object val = field.get(entity);

            if (field.getName().equals(primary.getName())) {
                whereQuery += name + " = '" + val + "' ";
            }

            updateQuery += name + " = '" + val;

            if (i != n - 1) {
                updateQuery += "', ";
            } else {
                updateQuery += "' ";
            }
        }

        String full = updateQuery + whereQuery;
        return this.connection.prepareStatement(full).execute();
    }

    private String getTableName(Class<?> aClass) {
        return aClass.getSimpleName().toLowerCase();
    }

    private <E> boolean insert(E entity, Field primary) throws SQLException, IllegalAccessException {
        String insertQuery = "INSERT INTO " + this.getTableName(entity.getClass()) + " ( ";

        Field[] fields = entity.getClass().getDeclaredFields();
        String insertColumns = "";
        String values = "";
        int n = fields.length;

        for (int i = 0; i < n; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            if (!field.getName().equals(primary.getName())) {
                insertColumns += field.getName();
                Object val = field.get(entity);
                values += "'" + val + "'";

                if (i != n - 1) {
                    insertColumns += ", ";
                    values += ", ";

                }
            }
        }

        insertQuery += insertColumns + " ) " + "VALUES ( " + values + " ) ";
        return connection.prepareStatement(insertQuery).execute();
    }


    private Field getId(Class<?> aClass) {
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.getName().equals("id")) {
                return field;
            }
        }

        return null;
    }

    @Override
    public <E> Iterable<E> find(Class<E> table) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Statement statement = this.connection.createStatement();
        String query = "SELECT * FROM " + this.getTableName(table) + " LIMIT 1000";
        ResultSet rs = statement.executeQuery(query);

        fillPersistedEntities(table, rs);

        return (Iterable<E>) Collections.unmodifiableCollection(this.persistedEntities);
    }

    private <E> void fillPersistedEntities(Class<E> table, ResultSet rs) throws SQLException, IllegalAccessException, InstantiationException {
        if (this.persistedEntities.size() > 0) {
            this.persistedEntities.clear();
        }

        while (rs.next()) {
            E entity = table.newInstance();
            try {
                this.fillEntity(table, rs, entity);
            } catch (SQLException e) {
                System.err.println("No match !");
            }
            this.persistedEntities.add(entity);
        }
    }


    @Override
    public <E> Iterable<E> find(Class<E> table, String where) throws SQLException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        Statement statement = this.connection.createStatement();
        String query = "SELECT * FROM " + this.getTableName(table) + " WHERE 1=1 " +
                (where != null ? "AND " + where : "") + " LIMIT 1000";
        ResultSet rs = statement.executeQuery(query);

        fillPersistedEntities(table, rs);

        return (Iterable<E>) Collections.unmodifiableCollection(this.persistedEntities);
    }

    @Override
    public <E> E findFirst(Class<E> table) throws SQLException, IllegalAccessException, InstantiationException {
        Statement statement = this.connection.createStatement();
        String query = "SELECT * FROM " + this.getTableName(table) + " LIMIT 1";
        ResultSet rs = statement.executeQuery(query);
        E entity = table.newInstance();
        rs.next();

        try {
            this.fillEntity(table, rs, entity);
        } catch (SQLException e) {
            System.err.println("No match !");
        }

        return entity;
    }

    @Override
    public <E> E findFirst(Class<E> table, String where) throws
            SQLException, IllegalAccessException, InstantiationException {
        Statement statement = this.connection.createStatement();
        String query = "SELECT * FROM " + this.getTableName(table) + " WHERE 1=1 " +
                (where != null ? "AND " + where : "") + " LIMIT 1";
        ResultSet rs = statement.executeQuery(query);
        E entity = table.newInstance();
        rs.next();

        try {
            this.fillEntity(table, rs, entity);
        } catch (SQLException e) {
            System.err.println("No match !");
        }

        return entity;
    }

    private <E> void fillEntity(Class<E> table, ResultSet rs, E entity) throws IllegalAccessException, SQLException {
        if (rs != null) {
            for (Field f : table.getDeclaredFields()) {
                f.setAccessible(true);
                String colName = f.getName();

                if (f.getType().equals(String.class)) {
                    f.set(entity, rs.getString(colName));
                } else if (f.getType().equals(Integer.class) || f.getType().equals(Integer.TYPE)) {
                    f.set(entity, rs.getInt(colName));
                } else if (f.getType().equals(Boolean.class) || f.getType().equals(Boolean.TYPE)) {
                    f.set(entity, rs.getBoolean(colName));
                } else if (f.getType().equals(Long.class) || f.getType().equals(Long.TYPE)) {
                    f.set(entity, rs.getLong(colName));
                } else if (f.getType().equals(LocalDate.class)) {
                    f.set(entity, rs.getDate(colName).toLocalDate());
                }

            }
        }
    }
}
