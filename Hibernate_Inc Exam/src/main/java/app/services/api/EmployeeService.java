package app.services.api;

import app.dto.bindings.xml.EmployeeImportXmlDto;
import app.dto.views.json.EmployeeExportJsonDto;
import app.entities.EmployeeCard;

import java.util.List;

public interface EmployeeService<Employee, Long> extends ServiceInterface<Employee, Long> {

    void persist(EmployeeImportXmlDto currentEmployeeDto);
    List<Object[]> productiveEmployees();

    List freeCards(List<EmployeeCard> cardsWithoutEmployee);

    List<EmployeeExportJsonDto> getProductiveEmployees(List<Object[]> employees);
}
