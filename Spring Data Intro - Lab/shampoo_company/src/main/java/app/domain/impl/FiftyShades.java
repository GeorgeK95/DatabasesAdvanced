package app.domain.impl;

import app.service.impl.BasicIngredient;
import app.service.impl.BasicShampoo;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
@SuppressWarnings("ALL")
@Entity
public class FiftyShades extends BasicShampoo {
    private String brand = "Fifty Shades";
    private BigDecimal price = new BigDecimal(6.69);
    private Size size = Size.SMALL;
    private ClassicLabel label = new ClassicLabel("Fifty Shades", "Tie the aroma");
    private Set<BasicIngredient> ingredients = new HashSet<BasicIngredient>() {{
        add(new Strawberry());
        add(new Nettle());
    }};

    public FiftyShades() {
    }
}
