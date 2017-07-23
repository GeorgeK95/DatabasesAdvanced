package app.domain.impl;

import app.domain.api.Batch;
import app.service.impl.base.BasicShampoo;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
@Entity
public class ProductionBatch implements Batch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private LocalDate batchDate;

    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL)//, targetEntity = BasicShampoo.class
    private Set<BasicShampoo> shampoos;

    public ProductionBatch() {
    }

    public ProductionBatch(LocalDate batchDate, Set<BasicShampoo> shampoos) {
        this.batchDate = batchDate;
        this.shampoos = shampoos;
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public LocalDate getBatchDate() {
        return this.batchDate;
    }

    @Override
    public void setBatchDate(LocalDate batchDate) {
        this.batchDate = batchDate;
    }

    @Override
    public Set<BasicShampoo> getShampoos() {
        return this.shampoos;
    }

    @Override
    public void setShampoos(Set<BasicShampoo> shampoos) {
        this.shampoos = shampoos;
    }
}
