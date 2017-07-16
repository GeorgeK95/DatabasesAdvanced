package FindLatest10Projects;

import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

/**
 * Created by George-Lenovo on 7/16/2017.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        String query = "select p\n" +
                "from Project as p\n" +
                "order by p.startDate desc";

        List<Project> projects = em.createQuery(query).setMaxResults(10).getResultList();

        projects.stream().sorted(Comparator.comparing(Project::getName))
                .forEach(x -> System.out.printf("%s %s %s %s\n", x.getName(), x.getDescription(), x.getStartDate(), x.getEndDate()));
        emf.close();
        em.close();
        System.out.println("Success.");
    }
}
