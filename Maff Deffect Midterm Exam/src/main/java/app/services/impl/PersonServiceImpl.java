package app.services.impl;

import app.dao.PersonDao;
import app.dao.PlanetDao;
import app.dto.binding.json.PersonJsonImportDto;
import app.entities.Person;
import app.services.api.PersonService;
import app.utils.DTOConverter;
import app.validations.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService<Person, Long> {

    @Autowired
    private PersonDao personDao;
    @Autowired
    private PlanetDao planetDao;

    @Override
    public Person findById(Long id) {
        return personDao.findOne(id);
    }

    @Override
    public List<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    public void save(Person object) {
        personDao.save(object);
    }

    @Override
    public List<Person> findByAnomaliesNull() {
        return personDao.findByAnomaliesNull();
    }

    @Override
    public void persist(PersonJsonImportDto personJsonImportDto) {
        Person person = DTOConverter.convert(personJsonImportDto, Person.class);
        person.setHomePlanet(planetDao.findByName(personJsonImportDto.getHomePlanetName()));
        if (DataValidator.isValid(person)) {
            this.save(person);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
