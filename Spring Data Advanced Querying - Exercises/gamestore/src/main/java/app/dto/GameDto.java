package app.dto;

import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public class GameDto {
    private String title;
    private BigDecimal price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
