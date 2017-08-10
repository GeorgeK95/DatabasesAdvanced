package app.services.impl;

import app.dao.SolarSystemsDao;
import app.dao.StarsDao;
import app.dto.binding.json.StarJsonImportDto;
import app.entities.Star;
import app.services.api.StarsService;
import app.utils.DTOConverter;
import app.validations.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StarsServiceImpl implements StarsService<Star, Long> {

    @Autowired
    private StarsDao starsDao;
    @Autowired
    private SolarSystemsDao solarSystemsDao;

    @Override
    public Star findById(Long id) {
        return starsDao.findOne(id);
    }

    @Override
    public List<Star> findAll() {
        return starsDao.findAll();
    }

    @Override
    public void save(Star object) {
        starsDao.save(object);
    }

    @Override
    public void persist(StarJsonImportDto importDto) {
        Star convert = DTOConverter.convert(importDto, Star.class);
        convert.setSolarSystem(solarSystemsDao.findByName(importDto.getSolarSystemName()));
        if (DataValidator.isValid(convert)) {
            this.save(convert);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
