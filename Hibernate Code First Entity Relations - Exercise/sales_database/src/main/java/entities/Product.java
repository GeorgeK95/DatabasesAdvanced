package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/19/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private String name;
    @Basic
    private BigDecimal quantity_price;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<Sale> productSales;

    public Product() {
    }

    public Set<Sale> getProductSales() {
        return productSales;
    }

    public void setProductSales(Set<Sale> sales) {
        this.productSales = sales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getQuantity_price() {
        return quantity_price;
    }

    public void setQuantity_price(BigDecimal quantity_price) {
        this.quantity_price = quantity_price;
    }
}
