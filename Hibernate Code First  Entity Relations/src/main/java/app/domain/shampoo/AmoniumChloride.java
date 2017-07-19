package app.domain.shampoo;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
@Entity
//@Table(name = "amoniumChloride")
public class AmoniumChloride extends BasicChemicalIngredient {
    private BigDecimal price = new BigDecimal(0.59);
    private String chemicalFormula = "NH4CL";

    public AmoniumChloride() {
        super();
    }
}
