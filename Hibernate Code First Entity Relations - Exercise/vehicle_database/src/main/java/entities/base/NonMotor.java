package entities.base;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity

public abstract class NonMotor extends BaseVehicle {

    public NonMotor() {
    }

    public NonMotor(String manufacturer, String model, BigDecimal price, int maxSpeed) {
        super(manufacturer, model, price, maxSpeed);
    }
}
