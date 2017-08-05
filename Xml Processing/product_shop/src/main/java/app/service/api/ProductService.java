package app.service.api;

import java.util.Set;

/**
 * Created by George-Lenovo on 8/1/2017.
 */
public interface ProductService<Product, Long> extends ServiceInterface<Product, Long> {
    Set<Object[]> productsInRange();
}
