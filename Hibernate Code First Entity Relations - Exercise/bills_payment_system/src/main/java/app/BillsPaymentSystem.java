package app;

import entities.BankAccount;
import entities.BillingDetail;
import entities.CreditCard;
import entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
public class BillsPaymentSystem {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bills_payment_system");
        EntityManager em = emf.createEntityManager();
        addDataToDb(em);
        emf.close();
    }

    private static void addDataToDb(EntityManager em) {
        em.getTransaction().begin();
        User ceco = new User("Cvetan", "Cvetanov", "1234567", "cv.cv@abv.bg");
        em.persist(ceco);
        User boiko = new User("Boiko", "Borisov", "777", "bbb@abv.bg");
        em.persist(boiko);

        BillingDetail creditCard = new CreditCard("CardTypeVip", "November", 2019);
        creditCard.setNumber(11);
        creditCard.setOwner(ceco);
        em.persist(creditCard);

        BillingDetail billingDetail = new BankAccount("KTB", "#cvetanVasilevCode");
        billingDetail.setOwner(boiko);
        billingDetail.setNumber(9);
        em.persist(billingDetail);

        em.getTransaction().commit();
        em.close();
    }
}
