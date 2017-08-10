package app.dto.binding.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StarJsonImportDto {
    @Expose
    private String name;
    @Expose
    @SerializedName("solarSystem")
    private String solarSystemName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSolarSystemName() {
        return solarSystemName;
    }

    public void setSolarSystemName(String solarSystemName) {
        this.solarSystemName = solarSystemName;
    }
}
