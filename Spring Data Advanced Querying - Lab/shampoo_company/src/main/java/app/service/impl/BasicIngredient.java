package app.service.impl;

import app.domain.api.Ingredient;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
@NamedQueries({@NamedQuery(name = "BasicIngredient.findBySumOfPrice",
        query = "SELECT b,sum(b.price) FROM BasicIngredient AS b WHERE b.price > :num group by b"),
        @NamedQuery(name = "BasicIngredient.findNamesAndBrands",
                query = "select b.name, s.brand from BasicIngredient as b inner join b.shampoos as s"),

        @NamedQuery(name = "BasicIngredient.deleteIgredientByName",
                query = "delete from BasicIngredient as b where b.name = :name")})

@SuppressWarnings("ALL")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class BasicIngredient implements Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String name;
    @Basic
    private BigDecimal price;

    @ManyToMany(mappedBy = "ingredients")//, targetEntity = BasicShampoo.class
    private Set<BasicShampoo> shampoos;

    public BasicIngredient() {
    }

    public BasicIngredient(String name, BigDecimal price) {
        this.setName(name);
        this.setPrice(price);
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public Set<BasicShampoo> getShampoos() {
        return shampoos;
    }

    public void setShampoos(Set<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
