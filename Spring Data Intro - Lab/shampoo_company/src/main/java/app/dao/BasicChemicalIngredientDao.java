package app.dao;

import app.domain.impl.BasicChemicalIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by George-Lenovo on 7/23/2017.
 */
@Repository
@Transactional
public interface BasicChemicalIngredientDao extends JpaRepository<BasicChemicalIngredient, Long> {
}
