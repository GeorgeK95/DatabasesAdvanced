package app.dao;

import app.model.Course;
import app.model.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Repository
public interface CourseDao extends JpaRepository<Course, Long> {
    @Query("select concat(c.name, ' ', count(r))\n" +
            "from Course c\n" +
            "inner join c.resources r\n" +
            "group by c.name\n" +
            "having count(r) > 5" +
            "order by count(r) desc, c.startDate desc")
    List<String> getCourseWithMoreThan5Resources();

    @Query("select c " +
            "from Course c " +
            "where c.startDate > '2000-01-01' and c.endDate < '2002-12-12'")
    List<Course> activeCources2001();
}
