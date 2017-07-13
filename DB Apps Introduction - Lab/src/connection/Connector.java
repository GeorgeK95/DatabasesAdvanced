package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by George-Lenovo on 7/12/2017.
 */
public class Connector {

    private static Connection connection = null;

    public Connector() {
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void doConnect(String driver, String userName, String password, String host, String port, String dbName) throws SQLException {
        String url = "jdbc:" + driver + "://" + host + ":" + port + "/" + dbName;
        connection = DriverManager.getConnection(url, userName, password);
    }
}
