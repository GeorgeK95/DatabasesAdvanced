package app.domain.impl;

import app.service.impl.base.BasicIngredient;
import app.service.impl.base.BasicShampoo;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
@SuppressWarnings("ALL")
@Entity
public class PinkPanther extends BasicShampoo {
    private String brand = "Pink Panther";
    private BigDecimal price = new BigDecimal(8.50);
    private Size size = Size.MEDIUM;
    private ClassicLabel label = new ClassicLabel("Pink Panther", "Pleasure in pink");
    private Set<BasicIngredient> ingredients = new HashSet<BasicIngredient>() {{
        add(new Lavender());
        add(new Nettle());
    }};

    public PinkPanther() {
        super();
    }
}
