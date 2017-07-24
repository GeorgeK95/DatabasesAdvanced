package entities.motor.ship;

import entities.base.Motor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity
public abstract class Ship extends Motor {
    private String nationality;
    private String captainName;
    private int crewSize;

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public int getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(int crewSize) {
        this.crewSize = crewSize;
    }

    public Ship() {
    }

    public Ship(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngines, String engineType, int tankCapacity) {
        super(manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
    }
}
