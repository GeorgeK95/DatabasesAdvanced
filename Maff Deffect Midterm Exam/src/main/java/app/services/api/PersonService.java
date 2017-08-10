package app.services.api;

import app.dto.binding.json.PersonJsonImportDto;

import java.util.List;

public interface PersonService<Person, Long> extends ServiceInterface<Person, Long> {
    List<app.entities.Person> findByAnomaliesNull();
    void persist(PersonJsonImportDto personJsonImportDto);
}
