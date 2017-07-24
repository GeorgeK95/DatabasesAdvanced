package entities;

import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
public interface Vehicle {
    String getManufacturer();

    String getModel();

    BigDecimal getPrice();

    int getMaxSpeed();
}
