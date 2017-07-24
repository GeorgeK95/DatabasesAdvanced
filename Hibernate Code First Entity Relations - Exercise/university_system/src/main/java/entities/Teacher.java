package entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity
@Table(name = "teacher")
//@DiscriminatorValue(value = "Teacher")
public class Teacher extends Person {
    private String email;
    private BigDecimal salaryPerHour;

    public Teacher() {
    }

    public Teacher(String email, BigDecimal salaryPerHour) {
        this.email = email;
        this.salaryPerHour = salaryPerHour;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(BigDecimal salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }
}
