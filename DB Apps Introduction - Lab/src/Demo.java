import connection.Connector;
import db.DBContext;
import db.EntityManager;
import model.User;

import java.sql.SQLException;

/**
 * Created by George-Lenovo on 7/12/2017.
 */
public class Demo {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Connector.doConnect("mysql", "root", "", "localhost", "3306", "MiniORM_DB");
        DBContext em = new EntityManager(Connector.getConnection());

        try {
//            9.	Fetch Users
            Iterable<User> foundUsers = em.find(User.class, " dateOfRegistration > '2010-12-31' and age >= 18");
            for (User foundUser : foundUsers) {
                System.out.println(foundUser);
            }
        } finally {
            em.closeConn();
            System.out.println("Success");
        }
    }
}
