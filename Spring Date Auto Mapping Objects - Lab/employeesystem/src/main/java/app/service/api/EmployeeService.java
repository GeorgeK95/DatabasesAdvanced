package app.service.api;

import java.util.Date;
import java.util.List;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public interface EmployeeService<Employee, Long> extends ServiceInterface<Employee, Long> {
    List<app.model.Employee> findEmployeesByBirthDayBefore(Date date);
}
