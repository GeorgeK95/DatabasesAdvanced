package app.dto.bindings.json;

import com.google.gson.annotations.Expose;

public class TownImportJsonDto {
    @Expose
    private String name;
    @Expose
    private int population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
