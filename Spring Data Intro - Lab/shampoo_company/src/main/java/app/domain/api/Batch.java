package app.domain.api;

import app.service.impl.BasicShampoo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface Batch extends Serializable {

    Long getId();

    void setId(Long id);

    LocalDate getBatchDate();

    void setBatchDate(LocalDate batchDate);

    Set<BasicShampoo> getShampoos();

    void setShampoos(Set<BasicShampoo> shampoos);
}

