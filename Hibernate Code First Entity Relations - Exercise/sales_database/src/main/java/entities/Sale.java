package entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by George-Lenovo on 7/19/2017.
 */
@SuppressWarnings("ALL")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne()
    @JoinColumn(nullable = false, name = "product_id")
    private Product product;
    @ManyToOne()
    @JoinColumn(nullable = false, name = "sale_id")
    private Customer customer;
    @ManyToOne()
    @JoinColumn(nullable = false, name = "location_id")
    private StoreLocation storeLocation;

    private Date date;

    public Sale() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product productId) {
        this.product = productId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customerId) {
        this.customer = customerId;
    }

    public StoreLocation getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
