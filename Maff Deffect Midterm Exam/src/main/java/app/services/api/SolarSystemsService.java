package app.services.api;

import app.dto.binding.json.SolarSystemJsonImportDto;

public interface SolarSystemsService<SolarSystem, Long> extends ServiceInterface<SolarSystem, Long> {

    void persist(SolarSystemJsonImportDto deserialized);
}
