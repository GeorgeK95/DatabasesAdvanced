package app.dto;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@XmlRootElement(name = "category")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryDto {
    @Expose
    @XmlAttribute
    private String name;

    @Expose
    @XmlElement(name = "products-count")
    private int productsCount;
    @Expose
    @XmlElement(name = "average-price")
    private BigDecimal averagePrice;
    @Expose
    @XmlElement(name = "total-revenue")
    private BigDecimal totalRevenue;

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
