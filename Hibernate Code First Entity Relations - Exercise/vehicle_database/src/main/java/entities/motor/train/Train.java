package entities.motor.train;

import entities.base.Motor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity
public class Train extends Motor {
    @OneToOne
    @JoinColumn(name = "locomotive_id", referencedColumnName = "locomotive_id")
    private Locomotive locomotive;
    private int numberOfCarriages;

    @OneToMany(mappedBy = "train")
    private Set<Carriage> carriages;


    public Train() {
    }

    public Train(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngines, String engineType, int tankCapacity, Locomotive locomotive, int numberOfCarriages, Set<Carriage> carriages) {
        super(manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
        this.locomotive = locomotive;
        this.numberOfCarriages = numberOfCarriages;
        this.carriages = carriages;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public int getNumberOfCarriages() {
        return numberOfCarriages;
    }

    public void setNumberOfCarriages(int numberOfCarriages) {
        this.numberOfCarriages = numberOfCarriages;
    }

    public Set<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(Set<Carriage> carriages) {
        this.carriages = carriages;
    }
}
