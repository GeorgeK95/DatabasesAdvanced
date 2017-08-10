package app.dto.view.json;

import com.google.gson.annotations.Expose;

public class PersonJsonExportDto {
    @Expose
    private String name;
    @Expose
    private PlanetJsonExportDto homePlanet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlanetJsonExportDto getHomePlanet() {
        return homePlanet;
    }

    public void setHomePlanet(PlanetJsonExportDto homePlanet) {
        this.homePlanet = homePlanet;
    }
}
