package app;


import entities.WizardDeposit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by George-Lenovo on 7/19/2017.
 */
public class Grigotts {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gringottsdatabase");
        EntityManager em = emf.createEntityManager();
        WizardDeposit dumbledore = InicialiseAndGetDumbledore(em);
        em.getTransaction().begin();
        em.persist(dumbledore);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    private static WizardDeposit InicialiseAndGetDumbledore(EntityManager em) {
        WizardDeposit dumbledore = new WizardDeposit();
        dumbledore.setFirstName("Albus");
        dumbledore.setLastName("Dumbledore");
        dumbledore.setAge(150);
        dumbledore.setMagicLandCreator("Antoich Peverell");
        dumbledore.setMagicLandSize(15);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 10, 20);
        Date depositStart = calendar.getTime();
        dumbledore.setDepositStartDate(depositStart);

        calendar.set(2020, 10, 20);
        Date depositEnd = calendar.getTime();
        dumbledore.setDepositExpirationDate(depositEnd);

        dumbledore.setDepositAmount(2000.24);
        dumbledore.setDepositCharge(0.2);
        dumbledore.setDepositExpired(false);

        return dumbledore;
    }
}
