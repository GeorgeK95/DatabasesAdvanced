package app.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    @Column(precision = 20)
    private BigDecimal travelledDistance;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cars_parts", joinColumns = {@JoinColumn(name = "car_id")},
            inverseJoinColumns = {@JoinColumn(name = "part_id")})
    private Set<Part> parts;

    public Set<Part> getParts() {
        return parts;
    }

    public Long getId() {
        return id;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(BigDecimal travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

}
