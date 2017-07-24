package entities.nonmotor;

import entities.base.NonMotor;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity

public class Bike extends NonMotor {
    private int shiftsCount;
    private String color;

    public Bike() {
    }

    public Bike(String manufacturer, String model, BigDecimal price, int maxSpeed, int shiftsCount, String color) {
        super(manufacturer, model, price, maxSpeed);
        this.shiftsCount = shiftsCount;
        this.color = color;
    }

    public int getShiftsCount() {
        return shiftsCount;
    }

    public void setShiftsCount(int shiftsCount) {
        this.shiftsCount = shiftsCount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
