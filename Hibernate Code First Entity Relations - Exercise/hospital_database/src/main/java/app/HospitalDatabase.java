package app;

import entities.Diagnose;
import entities.Medicament;
import entities.Patient;
import entities.Visitation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
public class HospitalDatabase {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospitaldb");
        EntityManager em = emf.createEntityManager();
        AddData(em);
        emf.close();
    }

    private static void AddData(EntityManager em) {
        em.getTransaction().begin();

        Visitation visitation = new Visitation();
        visitation.setDate(LocalDate.now());
        visitation.setComments("First visit for this month.");
        em.persist(visitation);

        Visitation visitation2 = new Visitation();
        visitation2.setDate(LocalDate.now());
        visitation2.setComments("Second visit for this month.");
        em.persist(visitation2);


        Medicament medicament = new Medicament();
        medicament.setName("Avamys");
        em.persist(medicament);

        Medicament medicament2 = new Medicament();
        medicament2.setName("Avamys2");
        em.persist(medicament2);

        Diagnose diagnose = new Diagnose();
        diagnose.setName("Diagnose#1");
        diagnose.setComments("Diagnose#1 comments");
        em.persist(diagnose);

        Diagnose diagnose2 = new Diagnose();
        diagnose2.setName("Diagnose#2");
        diagnose2.setComments("Diagnose#2 comments");
        em.persist(diagnose2);

        Set<Visitation> visitationSet = new HashSet<Visitation>() {{
            add(visitation);
            add(visitation2);
        }};
        Set<Diagnose> diagnoseSet = new HashSet<Diagnose>() {{
            add(diagnose);
            add(diagnose2);
        }};
        Set<Medicament> medicamentSet = new HashSet<Medicament>() {{
            add(medicament);
            add(medicament2);
        }};

        Patient patient = new Patient("Ivan", "Georgiev", "bul.Bulgaria", "ivanG@abv.bg", LocalDate.of(1995, 02, 02), new byte[10], true, visitationSet, diagnoseSet, medicamentSet);
        em.persist(patient);
        em.getTransaction().commit();
        em.close();

    }
}
