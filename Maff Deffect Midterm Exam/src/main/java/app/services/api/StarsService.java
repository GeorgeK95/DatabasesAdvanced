package app.services.api;

import app.dto.binding.json.StarJsonImportDto;

public interface StarsService<Star, Long> extends ServiceInterface<Star, Long> {

    void persist(StarJsonImportDto importDto);
}
