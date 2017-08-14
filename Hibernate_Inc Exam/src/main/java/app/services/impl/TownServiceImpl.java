package app.services.impl;

import app.dao.TownDao;
import app.dto.bindings.json.TownImportJsonDto;
import app.dto.views.xml.TownExportXmlDto;
import app.dto.views.xml.TownsExportXmlDto;
import app.entities.Town;
import app.services.api.TownService;
import app.utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TownServiceImpl implements TownService<Town, Long> {

    @Autowired
    private TownDao townDao;

    @Override
    public Town findById(Long id) {
        return townDao.findOne(id);
    }

    @Override
    public List<Town> findAll() {
        return townDao.findAll();
    }

    @Override
    public void save(Town object) {
        townDao.save(object);
    }

    @Override
    public List<Object[]> townClients() {
        return townDao.townClients();
    }

    @Override
    public void persist(TownImportJsonDto importJsonDto) {
        if (isValidDto(importJsonDto)) {
            Town town = DTOConverter.convert(importJsonDto, Town.class);
            this.save(town);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public TownsExportXmlDto getTotalClients(List<Object[]> foundTowns) {
        List<TownExportXmlDto> townDtos = new ArrayList<>();
        for (Object[] currentTown : foundTowns) {
            TownExportXmlDto dto = new TownExportXmlDto();
            dto.setName(currentTown[0].toString());
            dto.setPopulation(Integer.valueOf(currentTown[1].toString()));
            dto.setTownClients(Integer.valueOf(currentTown[2].toString()));
            townDtos.add(dto);
        }
        TownsExportXmlDto wrapper = new TownsExportXmlDto();
        wrapper.setTowns(townDtos);
        return wrapper;
    }

    private boolean isValidDto(TownImportJsonDto importJsonDto) {
        return importJsonDto.getName() != null && importJsonDto.getPopulation() != 0;
    }
}
