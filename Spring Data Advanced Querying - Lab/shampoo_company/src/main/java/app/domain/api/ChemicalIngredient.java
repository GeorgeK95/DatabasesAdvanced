package app.domain.api;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface ChemicalIngredient extends Ingredient {

    String getChemicalFormula();

    void setChemicalFormula(String chemicalFormula);
}

