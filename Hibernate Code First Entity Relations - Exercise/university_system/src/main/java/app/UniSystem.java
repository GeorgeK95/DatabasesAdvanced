package app;

import entities.Course;
import entities.Student;
import entities.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
public class UniSystem {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("universitydb");
        EntityManager em = emf.createEntityManager();
        addDataToDb(em);
        emf.close();
    }

    private static void addDataToDb(EntityManager em) {
        Course dbAdvance = new Course("dbAdvance", LocalDate.of(2017, 06, 24), LocalDate.of(2017, 8, 13), 15);
        Course dbAdvance2 = new Course("dbAdvance2", LocalDate.of(2017, 06, 24), LocalDate.of(2017, 8, 13), 15);

        Student stud = new Student(new BigDecimal(6.00), 10);
        stud.setFirstName("Anon");
        stud.setLastName("M");
        stud.setPhoneNumber("1111");
        Student stud2 = new Student(new BigDecimal(6.00), 10);
        stud2.setFirstName("Anon2");
        stud2.setLastName("M2");
        stud2.setPhoneNumber("1111");


        Teacher t = new Teacher("t@abv.bg", new BigDecimal(30));
        t.setFirstName("Maria");
        t.setLastName("Nankova");
        t.setPhoneNumber("213123213");

        dbAdvance.setTeacher(t);
        dbAdvance2.setTeacher(t);

        Set<Course> courseSet = new HashSet<Course>() {{
            add(dbAdvance);
            add(dbAdvance2);
        }};

        stud.setCourse(courseSet);
        stud2.setCourse(courseSet);
        em.getTransaction().begin();
        em.persist(dbAdvance);
        em.persist(dbAdvance2);
        em.persist(stud);
        em.persist(stud2);
        em.persist(t);

        em.getTransaction().commit();
        em.close();
    }
}
