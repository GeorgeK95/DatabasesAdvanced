package app.services.impl;

import app.dao.BranchDao;
import app.dao.EmployeeCardDao;
import app.dao.EmployeeDao;
import app.dto.bindings.xml.EmployeeImportXmlDto;
import app.dto.views.json.EmployeeExportJsonDto;
import app.dto.views.json.FreeCardsExportJsonDto;
import app.entities.Employee;
import app.entities.EmployeeCard;
import app.services.api.EmployeeService;
import app.utils.DTOConverter;
import app.validations.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService<Employee, Long> {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private BranchDao branchDao;
    @Autowired
    private EmployeeCardDao employeeCardDao;

    @Override
    public Employee findById(Long id) {
        return employeeDao.findOne(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public void save(Employee object) {
        employeeDao.save(object);
    }

    @Override
    public void persist(EmployeeImportXmlDto currentEmployeeDto) {
        Employee employee = DTOConverter.convert(currentEmployeeDto, Employee.class);
        employee.setBranch(branchDao.findByName(currentEmployeeDto.getBranchName()));
        setCardToEmployee(employee, currentEmployeeDto.getNumber());

        if (DataValidator.checkIsValid(employee)) {
            this.save(employee);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void setCardToEmployee(Employee employee, String cardNumber) {
        List<String> allCards = employeeDao.findAllByNumber();
        if (!allCards.contains(cardNumber)) {
            employee.setCard(employeeCardDao.findByNumber(cardNumber));
        }
    }

    @Override
    public List<Object[]> productiveEmployees() {
        return employeeDao.productiveEmployees();
    }

    @Override
    public List freeCards(List<EmployeeCard> cardsWithoutEmployee) {
        List<FreeCardsExportJsonDto> dtos = new ArrayList<>();
        for (EmployeeCard employeeCard : cardsWithoutEmployee) {
            EmployeeCard employeeCardDto = DTOConverter.convert(employeeCard, EmployeeCard.class);
            FreeCardsExportJsonDto card = DTOConverter.convert(employeeCardDto, FreeCardsExportJsonDto.class);
            dtos.add(card);
        }
        return dtos;
    }

    @Override
    public List<EmployeeExportJsonDto> getProductiveEmployees(List<Object[]> employees) {
        List<EmployeeExportJsonDto> dtos = new ArrayList<>();
        for (Object[] employee : employees) {
            EmployeeExportJsonDto dto = generateEmployeeDto(employee);
            dtos.add(dto);
        }
        return dtos;
    }

    private EmployeeExportJsonDto generateEmployeeDto(Object[] employee) {
        EmployeeExportJsonDto dto = new EmployeeExportJsonDto();
        dto.setFullName(employee[0].toString());
        dto.setPosition(employee[1].toString());
        dto.setNumber(employee[2].toString());
        return dto;
    }
}
