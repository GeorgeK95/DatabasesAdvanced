package app.dto.views.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownsExportXmlDto {
    @XmlElement(name = "town")
    private List<TownExportXmlDto> towns;

    public List<TownExportXmlDto> getTowns() {
        return towns;
    }

    public void setTowns(List<TownExportXmlDto> towns) {
        this.towns = towns;
    }
}
