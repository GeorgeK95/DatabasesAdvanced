package app.dto;

import com.google.gson.annotations.Expose;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public class UserDto {
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    //    @Expose
//    private Set<ProductDto> soldProducts;
    @Expose
    SoldProductsDto soldProducts;

    public SoldProductsDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(SoldProductsDto soldProducts) {
        this.soldProducts = soldProducts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
