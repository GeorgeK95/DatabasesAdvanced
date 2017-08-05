package app.dto;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class CustomerDto {
    //    @Expose
//    @XmlAttribute
//    @XmlElement
//    private Long id;
    @Expose
    @XmlAttribute(name = "full-name")
//    @XmlElement
    private String name;
//    @Expose
//    @XmlElement(name = "birth-date")
//    private String birthDate;
//    @Expose
//    @XmlElement(name = "is-young-driver")
//    private boolean isYoungDriver;
    //    @Expose
    private Set<SaleDto> sales;


    @Expose
    @XmlAttribute(name = "spent-money")
    private BigDecimal spentMoney;

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
    }

    @Expose
    @XmlAttribute(name = "bought-cars")
    private Long boughtCars;

    public Long getBoughtCars() {
        return boughtCars;
    }

    public void setBoughtCars(Long boughtCars) {
        this.boughtCars = boughtCars;
    }

    /*public Set<SaleDto> getSales() {
        return sales;
    }

    public void setSales(Set<SaleDto> sales) {
        this.sales = sales;
    }*/

   /* public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        this.isYoungDriver = youngDriver;
    }*/
}
