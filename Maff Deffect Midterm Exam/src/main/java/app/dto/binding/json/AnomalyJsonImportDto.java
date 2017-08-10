package app.dto.binding.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnomalyJsonImportDto {
    @Expose
    @SerializedName("originPlanet")
    private String originPlanetName;
    @Expose
    @SerializedName("teleportPlanet")
    private String teleportPlanetName;

    public String getOriginPlanetName() {
        return originPlanetName;
    }

    public void setOriginPlanetName(String originPlanetName) {
        this.originPlanetName = originPlanetName;
    }

    public String getTeleportPlanetName() {
        return teleportPlanetName;
    }

    public void setTeleportPlanetName(String teleportPlanetName) {
        this.teleportPlanetName = teleportPlanetName;
    }
}
