package app.dto.binding.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PersonJsonImportDto {
    @Expose
    private String name;
    @Expose
    @SerializedName("homePlanet")
    private String homePlanetName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomePlanetName() {
        return homePlanetName;
    }

    public void setHomePlanetName(String homePlanetName) {
        this.homePlanetName = homePlanetName;
    }
}
