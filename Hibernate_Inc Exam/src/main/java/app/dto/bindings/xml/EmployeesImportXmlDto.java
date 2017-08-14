package app.dto.bindings.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeesImportXmlDto {
    @XmlElement(name = "employee")
    private List<EmployeeImportXmlDto> employees;

    public List<EmployeeImportXmlDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeImportXmlDto> employees) {
        this.employees = employees;
    }
}
