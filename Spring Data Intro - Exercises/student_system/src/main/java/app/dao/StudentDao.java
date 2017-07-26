package app.dao;

import app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Repository
public interface StudentDao extends JpaRepository<Student, Long> {
    @Query("select s.name, count(sc), sum(sc.price), avg(sc.price) " +
            "from Student s " +
            "inner join s.courses sc " +
            "group by s.name " +
            "order by sum(sc.price) desc, count(sc) desc, s.name asc ")
    List<Object[]> getStudentInfo();

}
