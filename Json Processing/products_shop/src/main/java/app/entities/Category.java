package app.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 15)
    @Column(nullable = false)
    private String name;

    @ManyToMany/*(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)*/
    @JoinTable(name = "category_products", joinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    private Set<Product> products;


    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
