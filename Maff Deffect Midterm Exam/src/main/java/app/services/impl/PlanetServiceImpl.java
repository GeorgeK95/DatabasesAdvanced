package app.services.impl;

import app.dao.PlanetDao;
import app.dao.SolarSystemsDao;
import app.dao.StarsDao;
import app.dto.binding.json.PlanetJsonImportDto;
import app.entities.Planet;
import app.services.api.PlanetService;
import app.utils.DTOConverter;
import app.validations.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PlanetServiceImpl implements PlanetService<Planet, Long> {

    @Autowired
    private PlanetDao planetDao;
    @Autowired
    private SolarSystemsDao solarSystemsDao;
    @Autowired
    private StarsDao starsDao;

    @Override
    public Planet findById(Long id) {
        return planetDao.findOne(id);
    }

    @Override
    public List<Planet> findAll() {
        return planetDao.findAll();
    }

    @Override
    public void save(Planet object) {
        planetDao.save(object);
    }

    @Override
    public List<Planet> findByOriginAnomalyNull() {
        return planetDao.findByOriginAnomalyNull();
    }

    @Override
    public void persist(PlanetJsonImportDto planetJsonImportDto) {
        Planet planet = DTOConverter.convert(planetJsonImportDto, Planet.class);
        planet.setSolarSystem(solarSystemsDao.findByName(planetJsonImportDto.getSolarSystemName()));
        planet.setSun(starsDao.findByName(planetJsonImportDto.getSunName()));
        if (DataValidator.isValid(planet)) {
            this.save(planet);
            System.out.println(123);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
