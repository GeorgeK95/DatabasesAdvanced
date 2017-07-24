package entities.base;

import entities.Vehicle;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity
@Table(name = "vehicle")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseVehicle implements Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_id")
    private Long id;
    private String manufacturer;
    private String model;
    private BigDecimal price;
    private int maxSpeed;

    public BaseVehicle() {
    }

    public BaseVehicle(String manufacturer, String model, BigDecimal price, int maxSpeed) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public int getMaxSpeed() {
        return this.maxSpeed;
    }

}
