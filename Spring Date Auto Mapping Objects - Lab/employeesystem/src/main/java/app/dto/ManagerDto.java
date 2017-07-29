package app.dto;

import java.util.Set;

/**
 * Created by George-Lenovo on 7/28/2017.
 */
public class ManagerDto {
    private String firstName;
    private String lastName;

    private Set<EmployeeDto> managed;

    public Set<EmployeeDto> getManaged() {
        return managed;
    }

    public void setManaged(Set<EmployeeDto> managed) {
        this.managed = managed;
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

}
