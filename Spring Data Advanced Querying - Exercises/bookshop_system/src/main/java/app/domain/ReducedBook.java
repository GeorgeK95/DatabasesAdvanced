package app.domain;

import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/28/2017.
 */
public interface ReducedBook {
    void setTitle(String title);

    String getTitle();

    void setEditionType(EditionType editionType);

    String getEditionType();

    void setAgeRestriction(AgeRestriction ageRestriction);

    AgeRestriction getAgeRestriction();

    void setPrice(BigDecimal price);

    BigDecimal getPrice();

}
