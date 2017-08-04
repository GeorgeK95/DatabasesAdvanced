package app.service.impl;

import app.dao.CustomerDao;
import app.entities.Customer;
import app.service.api.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService<Customer, Long> {

    @Autowired
    private CustomerDao dao;

    @Override
    public Customer findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Customer object) {
        dao.delete(object);
    }

    @Override
    public List<Customer> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Customer object) {
        dao.save(object);
    }

    @Override
    public void saveList(List<Customer> object) {
        for (Customer customer : object) {
            dao.save(customer);
        }
    }

    @Override
    public Set<Customer> orderedCustomers() {
        return dao.orderedCustomers();
    }

    @Override
    public Set<Customer> totalSalesByCustomer() {
        return dao.totalSalesByCustomer();
    }
}
