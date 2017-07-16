package ConcurrentDatabaseChangesWithEntityManager;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by George-Lenovo on 7/15/2017.
 */
@SuppressWarnings("JpaQlInspection")
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");

        EntityManager em1 = emf.createEntityManager();
        EntityManager em2 = emf.createEntityManager();

        String q1 = "select t\n" +
                "from Town as t\n" +
                "where t.name = 'Sofia'";
        Town sf1 = (Town) em1.createQuery(q1).getSingleResult();

        em1.getTransaction().begin();
//        em1.lock(sf1, LockModeType.PESSIMISTIC_WRITE);
        sf1.setName(sf1.getName() + "change1");
        em2.getTransaction().begin();
//        em2.lock(sf1, LockModeType.PESSIMISTIC_WRITE);
        sf1.setName(sf1.getName() + "change2");

        em1.getTransaction().commit();
        em2.getTransaction().commit();
        em1.close();
        em2.close();
        emf.close();
    }
}

