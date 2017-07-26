package app.domain.impl;

import app.service.impl.BasicIngredient;
import app.service.impl.BasicShampoo;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
@Entity
//@Table(name = "mint")
public class Mint extends BasicIngredient {
    private BigDecimal price = new BigDecimal(3.54);
    public Mint() {
    }

    @Override
    public Set<BasicShampoo> getShampoos() {
        return null;
    }

    @Override
    public void setShampoos(Set<BasicShampoo> shampoos) {

    }
}
