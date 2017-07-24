package entities.motor;

import entities.base.Motor;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity

public class Car extends Motor {
    private int numberOfDoors;
    private String information;

    public Car() {
    }

    public Car(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngines, String engineType, int tankCapacity, int numberOfDoors, String information) {
        super(manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
        this.numberOfDoors = numberOfDoors;
        this.information = information;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
