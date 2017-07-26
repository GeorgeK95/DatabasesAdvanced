package app.service.api;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/23/2017.
 */
public interface BasicIngredientService<BasicIngredient, Long> extends ServiceInterface<BasicIngredient, Long> {
    List<app.service.impl.BasicIngredient> findBasicIngredientsByPriceNull();

    Set<app.service.impl.BasicIngredient> findBasicIngredientsByNameStartingWith(String prefix);

    List<BasicIngredient> findIngredientsByNames(Set<String> names);

    void updatePricesInNamesList(List<String> names);

    void increaseIngredientsPrice();

    List<Object[]> findBySumOfPrice(BigDecimal num);

    List<Object[]> findNamesAndBrands();

    void deleteIgredientByName(String name);
}
