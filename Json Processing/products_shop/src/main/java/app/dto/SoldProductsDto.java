package app.dto;

import com.google.gson.annotations.Expose;

import java.util.Set;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
public class SoldProductsDto {
    @Expose
    private int soldProductsCount;
    @Expose
    private Set<ProductDto> soldProducts;

    public int getSoldProductsCount() {
        return soldProductsCount;
    }

    public void setSoldProductsCount(int soldProductsCount) {
        this.soldProductsCount = soldProductsCount;
    }

    public Set<ProductDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
