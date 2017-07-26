package app.domain.api;

import app.service.impl.BasicShampoo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface Ingredient extends Serializable {
    Set<BasicShampoo> getShampoos();

    void setShampoos(Set<BasicShampoo> shampoos);


    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);
}

