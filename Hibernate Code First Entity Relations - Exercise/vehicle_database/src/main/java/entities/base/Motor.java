package entities.base;

import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity

public abstract class Motor extends BaseVehicle {
    private int numberOfEngines;
    private String engineType;
    private int tankCapacity;

    public Motor() {
    }

    public Motor(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngines, String engineType, int tankCapacity) {
        super(manufacturer, model, price, maxSpeed);
        this.numberOfEngines = numberOfEngines;
        this.engineType = engineType;
        this.tankCapacity = tankCapacity;
    }

    public int getNumberOfEngines() {
        return numberOfEngines;
    }

    public void setNumberOfEngines(int numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }


}
