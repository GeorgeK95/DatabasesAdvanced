package app.services.api;

import app.dto.binding.json.PlanetJsonImportDto;

import java.util.List;

public interface PlanetService<Planet, Long> extends ServiceInterface<Planet, Long> {
    List<app.entities.Planet> findByOriginAnomalyNull();
    void persist(PlanetJsonImportDto planetJsonImportDto);
}
