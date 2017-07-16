package RemoveObjects;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by George-Lenovo on 7/15/2017.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        List<Town> allTowns = em.createQuery("select t from Town as t", Town.class).getResultList();

        for (Town curr : allTowns) {
            if (curr.getName().length() > 5) {
                em.detach(curr);
            }
        }

        em.getTransaction().begin();
        for (Town curr : allTowns) {
            curr.setName(curr.getName().toLowerCase());
        }
        em.getTransaction().commit();

        em.close();
        emf.close();
        System.out.println("Success.");
    }
}
