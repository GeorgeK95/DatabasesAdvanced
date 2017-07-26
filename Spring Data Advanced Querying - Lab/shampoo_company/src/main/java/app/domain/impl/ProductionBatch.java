package app.domain.impl;

import app.domain.api.Batch;
import app.service.impl.BasicShampoo;

import javax.persistence.*;
import java.util.Date;
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
    private Date batchDate;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL)//, targetEntity = BasicShampoo.class
    private Set<BasicShampoo> shampoos;

    public ProductionBatch() {
    }

    public ProductionBatch(Date batchDate, Set<BasicShampoo> shampoos) {
        this.batchDate = batchDate;
        this.shampoos = shampoos;
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
    public Date getBatchDate() {
        return this.batchDate;
    }

    @Override
    public void setBatchDate(Date batchDate) {
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
