package app.dao.api.shampoo.interfaces;

import app.service.impl.shampoo.BasicIngredient;
import app.domain.shampoo.ClassicLabel;
import app.domain.shampoo.ProductionBatch;
import app.domain.shampoo.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface Shampoo extends Serializable {

    long getId();

    void setId(long id);

    String getBrand();

    void setBrand(String brand);

    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    Size getSize();

    void setSize(Size size);

    ClassicLabel getLabel();

    void setLabel(ClassicLabel label);

    ProductionBatch getBatch();

    void setBatch(ProductionBatch batch);

    Set<BasicIngredient> getIngredients();

    void setIngredients(Set<BasicIngredient> ingredients);
}

