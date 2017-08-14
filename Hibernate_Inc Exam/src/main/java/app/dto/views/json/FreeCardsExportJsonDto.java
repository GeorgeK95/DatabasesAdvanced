package app.dto.views.json;

import com.google.gson.annotations.Expose;

public class FreeCardsExportJsonDto {
    @Expose
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
