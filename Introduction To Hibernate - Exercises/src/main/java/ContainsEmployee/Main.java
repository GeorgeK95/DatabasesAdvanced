package ContainsEmployee;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 7/15/2017.
 */
@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();
        Scanner in = new Scanner(System.in);
        String[] fullName = in.nextLine().split("\\s+");
        String fName = fullName[0];
        String lName = fullName[1];
        String query = "select e\n" +
                "from Employee as e\n" +
                "where e.firstName = :fName and e.lastName= :lName";

        List<Employee> employeesList = em.createQuery(query).setParameter("fName", fName).setParameter("lName", lName).getResultList();

        if (employeesList.size() == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

        emf.close();
        em.clear();
        System.out.println("Success.");
    }
}
