package app.dao.api.shampoo.interfaces;

import app.service.impl.shampoo.BasicShampoo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public interface Batch extends Serializable {

    long getId();

    void setId(long id);

    LocalDate getBatchDate();

    void setBatchDate(LocalDate batchDate);

    Set<BasicShampoo> getShampoos();

    void setShampoos(Set<BasicShampoo> shampoos);
}

