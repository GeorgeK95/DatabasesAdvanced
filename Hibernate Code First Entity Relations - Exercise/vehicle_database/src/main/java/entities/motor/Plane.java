package entities.motor;

import entities.base.Motor;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity

public class Plane extends Motor {
    private String airlineOwner;
    private String color;
    private int passengersCapacity;

    public Plane() {
    }

    public Plane(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngines, String engineType, int tankCapacity) {
        super(manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
    }

    public String getAirlineOwner() {
        return airlineOwner;
    }

    public void setAirlineOwner(String airlineOwner) {
        this.airlineOwner = airlineOwner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    public void setPassengersCapacity(int passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }
}
