package app.dao;

import app.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
    @Query("select concat(e.firstName, ' ', e.lastName) as fullName, e.position, e.card.number from Employee e " +
            "inner join e.branch b " +
            "where size(b.products) >= 1" +
            "order by fullName asc, LENGTH(e.position) desc")
    List<Object[]> productiveEmployees();

    @Query("select e.card.number from Employee e")
    List<String> findAllByNumber();
}

