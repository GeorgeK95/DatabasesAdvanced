package app.services.impl;

import app.dao.AnomalyDao;
import app.dao.PersonDao;
import app.dao.PlanetDao;
import app.dto.binding.json.AnomalyJsonImportDto;
import app.dto.binding.json.AnomalyVictimsJsonImportDto;
import app.dto.binding.xml.AnomalyImportXmlDto;
import app.dto.binding.xml.VictimImportXmlDto;
import app.entities.Anomaly;
import app.entities.Person;
import app.entities.Planet;
import app.services.api.AnomalyService;
import app.utils.DTOConverter;
import app.validations.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class AnomalyServiceImpl implements AnomalyService<Anomaly, Long> {

    @Autowired
    private AnomalyDao anomalyDao;
    @Autowired
    private PlanetDao planetDao;
    @Autowired
    private PersonDao personDao;

    @Override
    public Anomaly findById(Long id) {
        return anomalyDao.findOne(id);
    }

    @Override
    public List<Anomaly> findAll() {
        return anomalyDao.findAll();
    }

    @Override
    public void save(Anomaly object) {
        anomalyDao.save(object);
    }

    @Override
    public void persist(AnomalyJsonImportDto jsonImportDto) {
        Anomaly anomaly = DTOConverter.convert(jsonImportDto, Anomaly.class);
        anomaly.setOriginPlanet(planetDao.findByName(jsonImportDto.getOriginPlanetName()));
        anomaly.setTeleportPlanet(planetDao.findByName(jsonImportDto.getTeleportPlanetName()));

        if (DataValidator.isValid(anomaly)) {
            this.save(anomaly);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void persistVictims(AnomalyVictimsJsonImportDto dto) {
        Long anomalyId = dto.getId();
        Anomaly anomaly = anomalyDao.findOne(anomalyId);
        if (anomaly != null) {
            Person victim = personDao.findByName(dto.getPerson());
            if (victim != null) {
                anomaly.addVictim(victim);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Anomaly biggestAnomaly() {
        return anomalyDao.biggestAnomaly();
    }

    @Override
    public void persistDto(AnomalyImportXmlDto anomalyImportXmlDto) {
        Anomaly anomaly = new Anomaly();
        Planet originPlanet = planetDao.findByName(anomalyImportXmlDto.getOriginPlanet());
        Planet teleportPlanet = planetDao.findByName(anomalyImportXmlDto.getTeleportPlanet());
        if (originPlanet != null && teleportPlanet != null) {
            anomaly.setOriginPlanet(originPlanet);
            anomaly.setTeleportPlanet(teleportPlanet);

            Set<Person> victims = new HashSet<>();
            for (VictimImportXmlDto victimImportXmlDto : anomalyImportXmlDto.getVictims()) {
                Person p = personDao.findByName(victimImportXmlDto.getName());
                if (p != null) {
                    victims.add(p);
                }
            }
            anomaly.setVictims(victims);
            this.save(anomaly);
        } else {
            throw new IllegalArgumentException();
        }
    }


}
