package app.services.api;

import app.dto.bindings.json.EmployeeCardImportJsonDto;

import java.util.List;

public interface EmployeeCardService<EmployeeCard, Long> extends ServiceInterface<EmployeeCard, Long> {
    List<EmployeeCard> findByEmployeeNullOrderByIdAsc();

    void persist(EmployeeCardImportJsonDto currentJson);
}
