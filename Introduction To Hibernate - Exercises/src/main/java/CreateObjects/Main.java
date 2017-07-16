package CreateObjects;

import entities.Address;
import entities.Department;
import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by George-Lenovo on 7/15/2017.
 */
public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
        EntityManager em = emf.createEntityManager();

        //create town
        Town burgas = new Town();
        burgas.setName("Burgas");

        //create addresses
        Address address1 = new Address();
        address1.setText("Aleko Bogoridi");
        address1.setTown(burgas);

        Address address2 = new Address();
        address2.setText("Vasil Levski");
        address2.setTown(burgas);

        Address address3 = new Address();
        address3.setText("Luben Karavelov");
        address3.setTown(burgas);

        Department trainingDepartment = new Department();
        trainingDepartment.setName("Training Department");

        //create employees
        Employee e1 = new Employee();
        e1.setFirstName("Ivan1");
        e1.setLastName("Ivanov1");
        e1.setAddress(address1);
        e1.setDepartment(trainingDepartment);

        Employee e2 = new Employee();
        e2.setFirstName("Ivan2");
        e2.setLastName("Ivanov2");
        e2.setAddress(address1);
        e2.setDepartment(trainingDepartment);

        Employee e3 = new Employee();
        e3.setFirstName("Ivan3");
        e3.setLastName("Ivanov3");
        e3.setAddress(address3);
        e3.setDepartment(trainingDepartment);

        Employee e4 = new Employee();
        e4.setFirstName("Ivan4");
        e4.setLastName("Ivanov4");
        e4.setAddress(address2);
        e4.setDepartment(trainingDepartment);

        Employee e5 = new Employee();
        e5.setFirstName("Ivan5");
        e5.setLastName("Ivanov5");
        e5.setAddress(address3);
        e5.setDepartment(trainingDepartment);
        int a = 5;

        em.getTransaction().begin();
        em.persist(burgas);
        em.persist(burgas);
        em.persist(address1);
        em.persist(address2);
        em.persist(address3);
        em.persist(trainingDepartment);
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        em.persist(e4);
        em.persist(e5);
        em.getTransaction().commit();

        em.close();
        emf.close();
        System.out.println("Success.");
    }
}
