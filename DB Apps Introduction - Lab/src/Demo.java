import connection.Connector;
import db.DBContext;
import db.EntityManager;
import model.User;

import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Created by George-Lenovo on 7/12/2017.
 */
public class Demo {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        Connector.doConnect("mysql", "root", "", "localhost", "3306", "MiniORM_DB");
        DBContext em = new EntityManager(Connector.getConnection());

        try {
//            persist(em);

//            9.	Fetch Users
            Iterable<User> foundUsers = em.find(User.class, " registration_date > '2010-12-31' and age >= 18");
            for (User foundUser : foundUsers) {
                System.out.println(foundUser);
            }
        } finally {
            em.closeConn();
            System.out.println("Success");
        }
    }

    private static void persist(DBContext em) throws SQLException, IllegalAccessException {
        User user = new User("Ricardo Kaka", 35, LocalDate.now());
        User user1 = new User("Pepe", 15, LocalDate.now());
        em.persist(user);
        em.persist(user1);
    }
}
