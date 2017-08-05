package app.dto;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
public class CarDto {
    //    @Expose
//    @XmlAttribute
//    private Long id;

  /*  public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    @Expose
//    @XmlElement
    @XmlAttribute
    private String make;
    @Expose
//    @XmlElement
    @XmlAttribute
    private String model;
    @Expose
//    @XmlElement(name = "travelled-distance")
    @XmlAttribute(name = "travelled-distance")
    private BigDecimal travelledDistance;

    /*@Expose
    @XmlElement(name = "part")
    private Set<PartDto> parts;*/

    @Expose
    @XmlElement(name = "parts")
    private PartsDto parts;

    public PartsDto getParts() {
        return parts;
    }

    public void setParts(PartsDto parts) {
        this.parts = parts;
    }
    /*public Set<PartDto> getParts() {
        return parts;
    }

    public void setParts(Set<PartDto> parts) {
        this.parts = parts;
    }*/
    /* @Expose
    private Set<String> partsName;
    @Expose
    private Set<BigDecimal> partsPrice;*/

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

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
