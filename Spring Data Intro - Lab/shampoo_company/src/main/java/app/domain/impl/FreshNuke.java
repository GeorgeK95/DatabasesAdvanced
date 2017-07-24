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
public class FreshNuke extends BasicShampoo {
    private String brand = "Fresh Nuke";
    private BigDecimal price = new BigDecimal(9.33);
    private Size size = Size.BIG;
    private ClassicLabel label = new ClassicLabel("Fresh Nuke", "Explosively cool");
    private Set<BasicIngredient> ingredients = new HashSet<BasicIngredient>() {{
        add(new Mint());
        add(new Nettle());
        add(new AmoniumChloride());
    }};

    public FreshNuke() {
        super();
    }
}
