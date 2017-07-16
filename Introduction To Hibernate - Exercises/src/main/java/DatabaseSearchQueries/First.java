package DatabaseSearchQueries;

import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by George-Lenovo on 7/15/2017.
 */
@SuppressWarnings("JpaQlInspection")
public class First {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        String query = "select a\n" +
                "from Address as a\n";// +
//                "join Employee as ee\n" +
//                "on ee.id = a.id\n" +
//                "join Town as t\n" +
//                "on t.id = a.id\n" +
//                "group by a.id\n" +
//                "order by count(ee.id) desc, t.name asc";
        List<Address> addresses = em.createQuery(query).getResultList();
        printList(addresses);
        em.getTransaction().commit();

        em.clear();
        emf.close();
        System.out.println("Success.");
    }

    private static void printList(List<Address> addresses) {
        addresses.stream().sorted((a, b) -> {
            int result = Integer.compare(b.getEmployees().size(), a.getEmployees().size());
            if (result == 0) {
                result = a.getTown().getName().compareTo(b.getTown().getName());
            }
            return result;
        }).limit(10).forEach(a -> System.out.printf("%s %s - %d employees%n",
                a.getText(),
                a.getTown().getName(),
                a.getEmployees().size()));

    }
}
