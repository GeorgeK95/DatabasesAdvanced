package app.service.api;

import java.util.List;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
public interface CustomerService<Customer, Long> extends ServiceInterface<Customer, Long> {
    List<app.entities.Customer> orderedCustomers();

    List<app.entities.Customer> totalSalesByCustomer();
}
