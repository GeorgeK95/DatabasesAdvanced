package DatabaseSearchQueries;

import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by George-Lenovo on 7/16/2017.
 */
@SuppressWarnings("ALL")
public class Third {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        String query = "select p\n" +
                "from Project as p\n" +
                "where p.startDate >= '2001-01-01 00:00:00' and p.startDate <= '2003-01-01 00:00:00'";
        List<Project> projects = em.createQuery(query).getResultList();
        print(projects);
        em.close();
        emf.close();
        System.out.println("Success.");
    }

    private static void print(List<Project> projects) {
        for (Project project : projects) {
            System.out.printf("-%s %s %s \n", project.getName(), project.getStartDate(), project.getEndDate());
            for (Employee employee : project.getEmployees()) {
                System.out.printf("--%s %s %s \n", employee.getFirstName(), employee.getLastName(), employee.getManager().getFirstName() + " " + employee.getManager().getLastName());
            }
        }
    }
}
