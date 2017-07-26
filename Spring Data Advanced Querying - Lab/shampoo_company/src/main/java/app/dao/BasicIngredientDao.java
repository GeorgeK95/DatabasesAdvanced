package app.dao;

import app.service.impl.BasicIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/23/2017.
 */
@Repository
@Transactional
public interface BasicIngredientDao extends JpaRepository<BasicIngredient, Long> {
    List<BasicIngredient> findBasicIngredientsByPriceNullOrderByNameDescPriceDesc();

    Set<BasicIngredient> findBasicIngredientsByNameStartingWith(String prefix);

    @Query("select i from BasicIngredient i where i.name in :names")
    List<BasicIngredient> findIngredientsByNames(@Param(value = "names") Set<String> names);

    @Query("update BasicIngredient i set i.price = i.price * 1.10 where i.name in :names")
    @Modifying
    void updatePricesInNamesList(@Param(value = "names") List<String> namesParam);

    @Query("update BasicIngredient i set i.price = i.price * 1.10")
    @Modifying
    void increaseIngredientsPrice();

    List<Object[]> findBySumOfPrice(@Param(value = "num") BigDecimal num);

    List<Object[]> findNamesAndBrands();

    @Modifying
    void deleteIgredientByName(@Param(value = "name") String name);
}
