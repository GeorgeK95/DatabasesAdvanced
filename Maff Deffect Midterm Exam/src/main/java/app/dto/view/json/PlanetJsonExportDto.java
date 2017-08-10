package app.dto.view.json;

import com.google.gson.annotations.Expose;

public class PlanetJsonExportDto {
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
