package app.dao;

import app.model.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Repository
public interface HomeworkDao extends JpaRepository<Homework, Long> {
}
