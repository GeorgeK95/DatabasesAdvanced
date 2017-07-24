package entities.motor.ship;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity
public class CruiseShip extends Ship {
    private int passengersCapacitiy;

    public CruiseShip() {
    }

    public CruiseShip(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngines, String engineType, int tankCapacity) {
        super(manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
    }

    public int getPassengersCapacitiy() {
        return passengersCapacitiy;
    }

    public void setPassengersCapacitiy(int passengersCapacitiy) {
        this.passengersCapacitiy = passengersCapacitiy;
    }
}
