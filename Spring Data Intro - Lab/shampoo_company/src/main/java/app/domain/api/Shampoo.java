package app.domain.api;

import app.domain.impl.ClassicLabel;
import app.domain.impl.ProductionBatch;
import app.domain.impl.Size;
import app.service.impl.BasicIngredient;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface Shampoo extends Serializable {

    Long getId();

    void setId(Long id);

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

