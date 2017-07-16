package entities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by George-Lenovo on 7/15/2017.
 */
public class InnitianSetup {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        System.out.println("Success.");
    }
}
