package IncreaseSalaries;

import entities.Employee;

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

        String query = "select e\n" +
                "from Employee as e\n" +
                "where e.department in (select d.id from Department as d where d.name in ('Engineering', 'Tool Design', 'Marketing', 'Information Services'))";

        List<Employee> employees = em.createQuery(query).getResultList();
        em.getTransaction().begin();
        increaseSalaries(employees);
        print(employees);
        em.getTransaction().commit();

        em.close();
        emf.close();
        System.out.println("Success.");
    }

    private static void print(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.printf("%s %s ($%s)\n", employee.getFirstName(), employee.getLastName(), employee.getSalary());
        }
    }

    private static void increaseSalaries(List<Employee> employees) {
        for (Employee employee : employees) {
            BigDecimal newSal = employee.getSalary().multiply(BigDecimal.valueOf(0.12)).add(employee.getSalary());
            employee.setSalary(newSal);
        }
    }
}
