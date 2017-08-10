package app.dto.binding.json;

import com.google.gson.annotations.Expose;

public class SolarSystemJsonImportDto {
    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
