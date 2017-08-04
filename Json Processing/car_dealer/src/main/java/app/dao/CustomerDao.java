package app.dao;

import app.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
    @Query("select c\n" +
            "from Customer c\n" +
            "order by c.birthDate asc, c.isYoungDriver desc")
    Set<Customer> orderedCustomers();

    @Query("select c from Customer c inner join c.sales s inner join s.car.parts p group by c " +
            "having count(s) >= 1 " +
            "order by sum(p.price) desc, count(s.customer) desc")
    Set<Customer> totalSalesByCustomer();
}
