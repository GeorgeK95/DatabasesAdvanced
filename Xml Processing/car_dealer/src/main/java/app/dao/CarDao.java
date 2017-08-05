package app.dao;

import app.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
@Repository
public interface CarDao extends JpaRepository<Car, Long> {
    @Query("select c from Car c where c.make like 'Toyota' " +
            "order by c.model asc, c.travelledDistance desc")
    Set<Car> toyotaCars();
}
