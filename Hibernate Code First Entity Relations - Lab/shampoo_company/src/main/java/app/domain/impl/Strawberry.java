package app.domain.impl;

import app.service.impl.base.BasicIngredient;
import app.service.impl.base.BasicShampoo;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
@Entity
//@Table(name = "strawberry")
public class Strawberry extends BasicIngredient {
    //    private Long id;
//    private String name = "Strawberry";
    private BigDecimal price = new BigDecimal(4.85);


    public Strawberry() {
        super();
//        this.name = name1;
//        this.price = price1;
    }

    @Override
    public Set<BasicShampoo> getShampoos() {
        return null;
    }

    @Override
    public void setShampoos(Set<BasicShampoo> shampoos) {

    }
}
