package app.service.api;

import app.domain.impl.ClassicLabel;
import app.domain.impl.ProductionBatch;
import app.domain.impl.Size;
import app.service.impl.BasicIngredient;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/23/2017.
 */
public interface BasicShampooService<BasicShampoo, Long> extends ServiceInterface<BasicShampoo, Long> {
    List<BasicShampoo> findBasicShampoosByBrand(String brand);

    List<BasicShampoo> findBasicShampoosByBrandAndSize(String brand, Size size);

    List<BasicShampoo> findBasicShampoosBySizeOrLabel(ClassicLabel label, Size size);

    List<BasicShampoo> findBasicShampoosByPriceAfter(BigDecimal price);

    List<BasicShampoo> findBasicShampoosByPriceBefore(BigDecimal price);

    List<app.service.impl.BasicShampoo> findShampoosByLabel(String subTitle);

    Set<app.service.impl.BasicShampoo> findShampoosByIngredients(Set<BasicIngredient> ingredients);

    Set<app.service.impl.BasicShampoo> findShampoosByIngredientsCount(int count);

    Set<app.service.impl.BasicShampoo> findBasicShampoosByBatchCount(ProductionBatch batch);

    Set<app.service.impl.BasicShampoo> findShampoosByIngredientPrice(BigDecimal sumParam);

    Set<app.service.impl.BasicShampoo> findShampoosWithDifferentLabel(String subTitle, ProductionBatch batch);

    List<Object[]> findBatchDateAndLabelTitle();
}
