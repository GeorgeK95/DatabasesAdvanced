package FindEmployeesBFirstName;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 7/16/2017.
 */
@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        Scanner in = new Scanner(System.in);
        String inputPattern = in.nextLine();
        String query = "select e\n" +
                "from Employee as e\n" +
                "where e.firstName like :pattern";
        Query parametrized = em.createQuery(query).setParameter("pattern", inputPattern + "%");
        List<Employee> employeeList = parametrized.getResultList();
        print(employeeList);

        em.close();
        emf.close();
        System.out.println("Success.");
    }

    private static void print(List<Employee> employeeList) {
        for (Employee employee : employeeList) {
            System.out.printf("%s %s - %s - ($%s)\n", employee.getFirstName(), employee.getLastName(), employee.getJobTitle(), employee.getSalary());
        }
    }
}
