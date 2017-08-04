package app.dto;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public class SaleDto {
    @Expose
    private CarDto car;
    //    @Expose
//    private String make;
//    @Expose
//    private String model;
    @Expose
    private String customerName;
    @Expose
    private BigDecimal discount;
    @Expose
    private BigDecimal price;
    @Expose
    private BigDecimal priceWithDiscount;

    public BigDecimal getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(BigDecimal priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }
}
