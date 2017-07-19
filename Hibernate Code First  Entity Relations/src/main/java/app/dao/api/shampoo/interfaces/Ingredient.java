package app.dao.api.shampoo.interfaces;

import app.service.impl.shampoo.BasicShampoo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface Ingredient extends Serializable {
    Set<BasicShampoo> getShampoos();

    void setShampoos(Set<BasicShampoo> shampoos);


    long getId();

    void setId(long id);

    String getName();

    void setName(String name);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);
}

