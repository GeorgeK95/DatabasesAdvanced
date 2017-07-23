//package app.app;
//
//import app.domain.api.Ingredient;
//import app.domain.impl.AmoniumChloride;
//import app.domain.impl.Mint;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
///**
// * Created by George-Lenovo on 7/18/2017.
// */
//public class ShampooSystem {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("shampoodb");
//        EntityManager em = emf.createEntityManager();
//
//        em.getTransaction().begin();
//        Ingredient am = new AmoniumChloride();
//        Ingredient mint = new Mint();
//        em.persist(am);
//        em.persist(mint);
//
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
//    }
//}
