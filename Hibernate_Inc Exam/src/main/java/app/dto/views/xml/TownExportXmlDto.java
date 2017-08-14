package app.dto.views.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class TownExportXmlDto {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private int population;
    @XmlAttribute(name = "town_clients")
    private int townClients;

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

    public int getTownClients() {
        return townClients;
    }

    public void setTownClients(int townClients) {
        this.townClients = townClients;
    }
}
