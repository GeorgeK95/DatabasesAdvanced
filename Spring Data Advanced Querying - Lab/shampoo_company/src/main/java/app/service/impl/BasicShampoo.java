package app.service.impl;

import app.domain.api.Shampoo;
import app.domain.impl.ClassicLabel;
import app.domain.impl.ProductionBatch;
import app.domain.impl.Size;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
@NamedQuery(name = "BasicShampoo.findBatchDateAndLabelTitle",
        query = "select b.batchDate, l.title from BasicShampoo as s inner join s.batch as b inner join s.label as l")
@SuppressWarnings("ALL")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class BasicShampoo implements Shampoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String brand;
    @Basic
    private BigDecimal price;
    @Enumerated(value = EnumType.STRING)
    private Size size;
    @OneToOne(optional = false, cascade = CascadeType.ALL)//, fetch = FetchType.EAGER
    @JoinColumn(name = "label_id", referencedColumnName = "id")
    private ClassicLabel label;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "batch_id", referencedColumnName = "id")
    private ProductionBatch batch;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "shampoosIngrediants",
            joinColumns = @JoinColumn(name = "shampoo_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    private Set<BasicIngredient> ingredients;


    public BasicShampoo() {
    }

    public BasicShampoo(String brand, BigDecimal price, Size size, ClassicLabel label, ProductionBatch batch, Set<BasicIngredient> ingredients) {
        this.brand = brand;
        this.price = price;
        this.size = size;
        this.label = label;
        this.batch = batch;
        this.ingredients = ingredients;
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
    public String getBrand() {
        return this.brand;
    }

    @Override
    public void setBrand(String brand) {
        this.brand = brand;
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
    public Size getSize() {
        return this.size;
    }

    @Override
    public void setSize(Size size) {
        this.size = size;
    }

    @Override
    public ClassicLabel getLabel() {
        return this.label;
    }

    @Override
    public void setLabel(ClassicLabel label) {
        this.label = label;
    }

    @Override
    public ProductionBatch getBatch() {
        return this.batch;
    }

    @Override
    public void setBatch(ProductionBatch batch) {
        this.batch = batch;
    }

    @Override
    public Set<BasicIngredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public void setIngredients(Set<BasicIngredient> ingredients) {
        this.ingredients = ingredients;
    }
}
