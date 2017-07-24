package entities.motor.ship;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity
public class CargoShip extends Ship {
    private Long maxLoadKg;

    public CargoShip() {
    }

    public CargoShip(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngines, String engineType, int tankCapacity) {
        super(manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
    }

    public Long getMaxLoadKg() {
        return maxLoadKg;
    }

    public void setMaxLoadKg(Long maxLoadKg) {
        this.maxLoadKg = maxLoadKg;
    }
}
