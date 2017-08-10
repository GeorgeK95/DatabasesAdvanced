package app.services.impl;

import app.dao.SolarSystemsDao;
import app.dto.binding.json.SolarSystemJsonImportDto;
import app.entities.SolarSystem;
import app.services.api.SolarSystemsService;
import app.utils.DTOConverter;
import app.validations.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SolarSystemsServiceImpl implements SolarSystemsService<SolarSystem, Long> {

    @Autowired
    private SolarSystemsDao solarSystemsDao;

    @Override
    public SolarSystem findById(Long id) {
        return solarSystemsDao.findOne(id);
    }

    @Override
    public List<SolarSystem> findAll() {
        return solarSystemsDao.findAll();
    }

    @Override
    public void save(SolarSystem object) {
        solarSystemsDao.save(object);
    }

    @Override
    public void persist(SolarSystemJsonImportDto deserialized) {
        SolarSystem convert = DTOConverter.convert(deserialized, SolarSystem.class);
        if (DataValidator.isValid(convert)) {
            this.save(convert);
        } else {
            throw new IllegalArgumentException("Solar System must have name");
        }
    }
}
