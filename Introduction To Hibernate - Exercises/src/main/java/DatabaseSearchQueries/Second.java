package DatabaseSearchQueries;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 7/16/2017.
 */
@SuppressWarnings("ALL")
public class Second {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        String query = "select e\n" +
                "from Employee as e\n" +
                "where e.id = 147";
        Employee linda = (Employee) em.createQuery(query).getSingleResult();
        print(linda);
        em.close();
        emf.close();
        System.out.println("Success.");
    }

    private static void print(Employee linda) {
        System.out.printf("%s %s %s\n", linda.getFirstName(), linda.getLastName(), linda.getJobTitle());
        List<Project> lindaProjects = linda.getProjects().stream().collect(Collectors.toList());
        lindaProjects
                .stream()
                .sorted(Comparator.comparing(x -> x.getName()))
                .forEach(x -> System.out.println("Project name: " + x.getName()));

    }
}
