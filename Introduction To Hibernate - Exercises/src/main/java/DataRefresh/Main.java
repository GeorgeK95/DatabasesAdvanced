package DataRefresh;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by George-Lenovo on 7/15/2017.
 */
public class Main {
    @SuppressWarnings("JpaQlInspection")
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        String query = "select e from Employee as e where e.id = 4";
        Employee rob = (Employee) em.createQuery(query).getSingleResult();
        rob.setFirstName(rob.getFirstName().toUpperCase());

        em.getTransaction().begin();
        em.refresh(rob);
        em.getTransaction().commit();

        em.close();
        emf.close();
        System.out.println(rob.getFirstName());
    }
}
