package app.dao;

import app.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Repository
public interface ProductDao extends JpaRepository<Product, Long> {
    @Query("select p.name,p.price,concat(p.seller.firstName,' ', p.seller.lastName) from Product p " +
            " where p.price between 500 and 1000 and p.buyer is null " +
            "order by p.price asc")
    Set<Object[]> productsInRange();

}
