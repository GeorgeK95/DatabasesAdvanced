package AddingNewAddressAndUpdatingEmployee;

import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by George-Lenovo on 7/15/2017.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Address vitoshka = new Address();
        vitoshka.setText("Vitoshka15");
        em.persist(vitoshka);

        String query = "Select e from Employee as e\n" +
                "WHERE lastName = 'Nakov'";

        Employee nakov = (Employee) em.createQuery(query).getSingleResult();
        nakov.setAddress(vitoshka);
        em.persist(nakov);

        em.getTransaction().commit();
        em.clear();
        emf.close();
        System.out.println("Success.");
    }
}
