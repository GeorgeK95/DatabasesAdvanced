package app.services.impl;

import app.dao.EmployeeCardDao;
import app.dto.bindings.json.EmployeeCardImportJsonDto;
import app.entities.EmployeeCard;
import app.services.api.EmployeeCardService;
import app.utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeCardServiceImpl implements EmployeeCardService<EmployeeCard, Long> {

    @Autowired
    private EmployeeCardDao employeeCardDao;

    @Override
    public EmployeeCard findById(Long id) {
        return employeeCardDao.findOne(id);
    }

    @Override
    public List<EmployeeCard> findAll() {
        return employeeCardDao.findAll();
    }

    @Override
    public void save(EmployeeCard object) {
        employeeCardDao.save(object);
    }

    @Override
    public List<EmployeeCard> findByEmployeeNullOrderByIdAsc() {
        return employeeCardDao.findByEmployeeNullOrderByIdAsc();
    }

    @Override
    public void persist(EmployeeCardImportJsonDto currentJson) {
        if (isValidDto(currentJson)) {
            EmployeeCard card = DTOConverter.convert(currentJson, EmployeeCard.class);
            this.save(card);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean isValidDto(EmployeeCardImportJsonDto importJsonDto) {
        List<String> all = this.employeeCardDao.findAll().stream().map(EmployeeCard::getNumber).collect(Collectors.toList());
        return importJsonDto.getNumber() != null && !all.contains(importJsonDto.getNumber());
    }
}
