package app.services.api;

import app.dto.bindings.json.TownImportJsonDto;
import app.dto.views.xml.TownsExportXmlDto;

import java.util.List;

public interface TownService<Town, Long> extends ServiceInterface<Town, Long> {
    List<Object[]> townClients();

    void persist(TownImportJsonDto importJsonDto);

    TownsExportXmlDto getTotalClients(List<Object[]> foundTowns);
}
