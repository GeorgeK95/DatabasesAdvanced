package EmployeeQueries;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 7/15/2017.
 */
public class EmployeesFromSeatle {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        String salaryQuery = "select e \n" +
                "from Employee as e\n" +
                "where e.department = (select d.id from Department as d where d.name = 'Research and Development')";

        List<Employee> results = em.createQuery(salaryQuery).getResultList();
        results.stream().sorted((a, b) -> {
            int result = a.getSalary().compareTo(b.getSalary());
            if (result == 0) {
                result = b.getFirstName().compareTo(a.getFirstName());
            }
            return result;
        }).forEach(System.out::println);

        emf.close();
        em.clear();
        System.out.println("Success.");
    }
}
