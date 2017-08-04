package app.service.api;

import java.util.Set;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
public interface CustomerService<Customer, Long> extends ServiceInterface<Customer, Long> {
    Set<app.entities.Customer> orderedCustomers();

    Set<Customer> totalSalesByCustomer();
}
