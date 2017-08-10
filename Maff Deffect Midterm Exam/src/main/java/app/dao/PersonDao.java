package app.dao;

import app.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao extends JpaRepository<Person, Long> {
    Person findByName(String name);
    List<Person> findByAnomaliesNull();
}
