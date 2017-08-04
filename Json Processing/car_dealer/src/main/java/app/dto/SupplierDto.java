package app.dto;

import com.google.gson.annotations.Expose;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public class SupplierDto {
    @Expose
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }

    @Expose
    private String name;
    @Expose
    private boolean isImporter;
    @Expose
    private int partsCount;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        this.isImporter = importer;
    }
}
