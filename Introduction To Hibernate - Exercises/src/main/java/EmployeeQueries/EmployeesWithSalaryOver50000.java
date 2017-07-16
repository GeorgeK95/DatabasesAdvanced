package EmployeeQueries;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by George-Lenovo on 7/15/2017.
 */
public class EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        String salaryQuery = "select  e.firstName\n" +
                "from Employee as e\n" +
                "where e.salary > 50000";

        List<String> employeesNames = em.createQuery(salaryQuery).getResultList();
        printNames(employeesNames);
        emf.close();
        em.clear();
        System.out.println("Success.");

    }

    private static void printNames(List<String> employeesNames) {
        for (String employeesName : employeesNames) {
            System.out.println(employeesName);
        }
    }
}
