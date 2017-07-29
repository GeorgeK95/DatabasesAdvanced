package app.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/28/2017.
 */
public class EmployeeDto implements Serializable {
    private String firstName;
    private String lastName;
    private BigDecimal salary;
    private String addressAddress;
    private String managerLastName;

    public String getManagerLastName() {
        return managerLastName;
    }

    public void setManagerLastName(String managerLastName) {
        this.managerLastName = managerLastName;
    }

    public String getAddressAddress() {
        return addressAddress;
    }

    public void setAddressAddress(String addressAddress) {
        this.addressAddress = addressAddress;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
