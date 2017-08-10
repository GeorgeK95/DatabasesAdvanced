package app.dto.view.json;

import com.google.gson.annotations.Expose;

public class AnomalyJsonExportDto {
    @Expose
    private Long id;
    @Expose
    private PlanetJsonExportDto originPlanet;
    @Expose
    private PlanetJsonExportDto teleportPlanet;
    @Expose
    private int victimsCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlanetJsonExportDto getOriginPlanet() {
        return originPlanet;
    }

    public void setOriginPlanet(PlanetJsonExportDto originPlanet) {
        this.originPlanet = originPlanet;
    }

    public PlanetJsonExportDto getTeleportPlanet() {
        return teleportPlanet;
    }

    public void setTeleportPlanet(PlanetJsonExportDto teleportPlanet) {
        this.teleportPlanet = teleportPlanet;
    }

    public int getVictimsCount() {
        return victimsCount;
    }

    public void setVictimsCount(int victimsCount) {
        this.victimsCount = victimsCount;
    }
}
