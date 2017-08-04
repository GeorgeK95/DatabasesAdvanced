package app.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public class CategoryDto {
    @Expose
    private String name;
    @Expose
    private int productsCount;
    @Expose
    private BigDecimal averagePrice;
    @Expose
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
