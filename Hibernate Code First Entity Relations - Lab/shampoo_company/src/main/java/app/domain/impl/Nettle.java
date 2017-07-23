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
//@Table(name = "nettle")
public class Nettle extends BasicIngredient {
    private BigDecimal price = new BigDecimal(6.12);

    public Nettle() {
        super();
    }

    @Override
    public Set<BasicShampoo> getShampoos() {
        return null;
    }

    @Override
    public void setShampoos(Set<BasicShampoo> shampoos) {

    }
}
