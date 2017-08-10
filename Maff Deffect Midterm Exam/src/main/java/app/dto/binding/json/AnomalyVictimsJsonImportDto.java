package app.dto.binding.json;

import com.google.gson.annotations.Expose;

public class AnomalyVictimsJsonImportDto {
    @Expose
    private Long id;
    @Expose
    private String person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
