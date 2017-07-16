package RemoveTowns;

import entities.Address;
import entities.Employee;
import entities.Town;

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
        String inputTown = in.nextLine();
        String townQuery = "select t \n" +
                "from Town as t\n" +
                "where t.name = '" + inputTown + "'";
        String addressQuery = "select a\n" +
                "from Address as a\n" +
                "where a.town = ";

        Town town = (Town) em.createQuery(townQuery).getSingleResult();
        addressQuery += town.getId();
        List<Address> addresses = em.createQuery(addressQuery).getResultList();

        deleteObjects(town, addresses, em);
        print(addresses.size(), town.getName());

        em.close();
        emf.close();
        System.out.println("Success.");
    }

    private static void print(int addressesCount, String townName) {
        if (addressesCount == 1) {
            System.out.printf("%d address in %s was deleted", addressesCount, townName);

        } else {
            System.out.printf("%d addresses in %s were deleted", addressesCount, townName);
        }
    }

    private static void deleteObjects(Town town, List<Address> addresses, EntityManager em) {
        String employeeQuery = "select e\n" +
                "from Employee as e\n" +
                "where e.address = :id";
        Query removeEmployeeQuery = em.createQuery(employeeQuery);
        for (Address address : addresses) {
            int bb = address.getId();
            removeEmployeeQuery.setParameter("id", address);

            List<Employee> employees = removeEmployeeQuery.getResultList();
            for (Employee employee : employees) {
                em.getTransaction().begin();
                employee.setAddress(null);
                em.getTransaction().commit();
            }

            em.getTransaction().begin();
            em.remove(address);
            em.getTransaction().commit();
        }

        em.getTransaction().begin();
        em.remove(town);
        em.getTransaction().commit();
    }
}
