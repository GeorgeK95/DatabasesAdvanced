package app.dto;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDto {
    @Expose
    @XmlAttribute(name = "first-name")
    private String firstName;
    @Expose
    @XmlAttribute(name = "last-name")
    private String lastName;
    @Expose
    @XmlElement(name = "sold-products")
    private ProductsDto products;

    public ProductsDto getProducts() {
        return products;
    }

    public void setProducts(ProductsDto products) {
        this.products = products;
    }

    @Expose
    @XmlAttribute(name = "age")
    private int age;

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
