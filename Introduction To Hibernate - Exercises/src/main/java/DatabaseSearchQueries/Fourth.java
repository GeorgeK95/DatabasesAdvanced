package DatabaseSearchQueries;

import entities.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;

/**
 * Created by George-Lenovo on 7/16/2017.
 */
@SuppressWarnings("ALL")
public class Fourth {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        String query = "select d\n" +
                "from Department as d\n" +
                "group by d.id\n";
        List<Department> results = em.createQuery(query).getResultList();
        print(results);
        em.close();
        emf.close();
        System.out.println("Success.");
    }

    private static void print(List<Department> results) {
        System.out.println(results.size());
        results
                .stream()
                .filter(x -> x.getEmployees().size() > 5)
                .sorted(Comparator.comparing(x -> x.getEmployees().size()))
                .forEach(x -> System.out.printf("--%s - Manager: %s, Employees: %d\n", x.getName(), x.getManager().getLastName(), x.getEmployees().size()));
    }
}
