package EmployeesMaximumSalaries;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by George-Lenovo on 7/16/2017.
 */
@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        String query = "select d.name\n" +
                "from Department as d\n" +
                "join Employee as e\n" +
                "on e.department.id = d.id\n" +
                "group by d.id";
        String query2 = "select max(e.salary)\n" +
                "from Department as d\n" +
                "join Employee as e\n" +
                "on e.department.id = d.id\n" +
                "group by d.id";
        List<String> names = em.createQuery(query).getResultList();
        List<BigDecimal> salaries = em.createQuery(query2).getResultList();

        print(names, salaries);
        em.close();
        emf.close();
        System.out.println("Success.");
    }

    private static void print(List<String> names, List<BigDecimal> salaries) {
        for (int i = 0; i < names.size(); i++) {
            String nam = names.get(i);
            BigDecimal sal = salaries.get(i);
            System.out.printf("%s - %s\n", nam, sal);
        }
    }
}
