package app.dao;

import app.domain.impl.ClassicLabel;
import app.domain.impl.ProductionBatch;
import app.domain.impl.Size;
import app.service.impl.BasicIngredient;
import app.service.impl.BasicShampoo;
import org.springframework.data.jpa.repository.JpaRepository;
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
public interface BasicShampooDao extends JpaRepository<BasicShampoo, Long> {
    List<BasicShampoo> findBasicShampoosByBrand(String brand);

    List<BasicShampoo> findBasicShampoosByBrandAndSize(String brand, Size size);

    List<BasicShampoo> findBasicShampoosBySizeOrLabelOrderByPriceAsc(Size size, ClassicLabel label);

    List<BasicShampoo> findBasicShampoosByPriceAfterOrderByBrandDesc(BigDecimal price);

    List<BasicShampoo> findBasicShampoosByPriceBefore(BigDecimal price);

    @Query("select s from BasicShampoo as s where s.label.subTitle = :subTitle")
    List<BasicShampoo> findShampoosByLabel(@Param(value = "subTitle") String subTitle);

    @Query("select s from BasicShampoo as s inner join s.ingredients as i where i in :ingredients")
    Set<BasicShampoo> findShampoosByIngredients(@Param(value = "ingredients") Set<BasicIngredient> ingredients);

    @Query("select s from BasicShampoo as s where s.ingredients.size < :count")
    Set<BasicShampoo> findShampoosByIngredientsCount(@Param(value = "count") int count);

    @Query("select s from BasicShampoo as s inner join s.ingredients as i group by s having sum(i.price) < :sumParam")
    Set<BasicShampoo> findShampoosByIngredientPrice(@Param(value = "sumParam") BigDecimal sumParam);


    @Query("select s from BasicShampoo as s where s.label.subTitle != :subTitle and s.batch = :batch")
    Set<BasicShampoo> findShampoosWithDifferentLabel(@Param(value = "subTitle") String subTitle, @Param(value = "batch") ProductionBatch batch);

    @Query("select s from BasicShampoo as s where s.batch = :batch")
    Set<BasicShampoo> findBasicShampoosByBatch(ProductionBatch batch);

    List<Object[]> findBatchDateAndLabelTitle();
}
