package app.dao;

import app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Repository
public interface EmployeeDao extends JpaRepository<Employee, Long> {
    List<Employee> findEmployeesByBirthDayBeforeOrderBySalaryDesc(Date date);
}
