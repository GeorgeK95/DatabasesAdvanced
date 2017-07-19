package app.domain.shampoo;

import app.service.impl.shampoo.BasicIngredient;
import app.service.impl.shampoo.BasicShampoo;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
@Entity
//@Table(name = "lavender")
public class Lavender extends BasicIngredient {
    private BigDecimal price = new BigDecimal(2);

    public Lavender() {
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
