package app.service.impl;

import app.dao.EmployeeDao;
import app.model.Employee;
import app.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService<Employee, Long> {

    @Autowired
    private EmployeeDao dao;

    @Override
    public Employee findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Employee object) {
        dao.delete(object);
    }

    @Override
    public List<Employee> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Employee object) {
        dao.save(object);
    }

    @Override
    public List<Employee> findEmployeesByBirthDayBefore(Date date) {
        return dao.findEmployeesByBirthDayBeforeOrderBySalaryDesc(date);
    }
}
