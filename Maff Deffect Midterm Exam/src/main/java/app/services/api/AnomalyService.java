package app.services.api;

import app.dto.binding.json.AnomalyJsonImportDto;
import app.dto.binding.json.AnomalyVictimsJsonImportDto;
import app.dto.binding.xml.AnomalyImportXmlDto;

public interface AnomalyService<Anomaly, Long> extends ServiceInterface<Anomaly, Long> {

    void persist(AnomalyJsonImportDto jsonImportDto);

    void persistVictims(AnomalyVictimsJsonImportDto dto);
    app.entities.Anomaly biggestAnomaly();

    void persistDto(AnomalyImportXmlDto anomalyImportXmlDto);
}
