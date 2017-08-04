package app.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public class ProductDto {
//    @Expose
    private int productsCount;
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
//    @Expose
    private String buyerFirstName;
//    @Expose
    private String buyerLastName;

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public int getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(int productsCount) {
        this.productsCount = productsCount;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }

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
