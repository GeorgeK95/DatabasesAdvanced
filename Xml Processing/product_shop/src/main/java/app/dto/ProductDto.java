package app.dto;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductDto {
    @Expose
    @XmlAttribute
//    @XmlElement
    private String name;
    @Expose
    @XmlAttribute
//    @XmlElement
    private BigDecimal price;

    /*@Expose
    @XmlElement(name = "buyer-first-name")
    private String buyerFirstName;
    @Expose
    @XmlElement(name = "buyer-last-name")
    private String buyerLastName;*/

   /* public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
