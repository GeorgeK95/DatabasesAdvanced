package app.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public class CarDto {
    //    @Expose
    private Long id;
    @Expose
    private String make;
    @Expose
    private String model;
    @Expose
    private BigDecimal travelledDistance;
    //    @Expose
    private Set<PartDto> parts;

    public Set<PartDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartDto> parts) {
        this.parts = parts;
    }
    /* @Expose
    private Set<String> partsName;
    @Expose
    private Set<BigDecimal> partsPrice;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
