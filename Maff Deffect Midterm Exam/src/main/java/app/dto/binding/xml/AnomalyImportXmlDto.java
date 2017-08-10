package app.dto.binding.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class AnomalyImportXmlDto {
    @XmlAttribute(name = "origin-planet")
    private String originPlanet;
    @XmlAttribute(name = "teleport-planet")
    private String teleportPlanet;

    @XmlElement(name = "victim")
    @XmlElementWrapper(name = "victims")
    private List<VictimImportXmlDto> victims;

    public String getOriginPlanet() {
        return originPlanet;
    }

    public void setOriginPlanet(String originPlanet) {
        this.originPlanet = originPlanet;
    }

    public String getTeleportPlanet() {
        return teleportPlanet;
    }

    public void setTeleportPlanet(String teleportPlanet) {
        this.teleportPlanet = teleportPlanet;
    }

    public List<VictimImportXmlDto> getVictims() {
        return victims;
    }

    public void setVictims(List<VictimImportXmlDto> victims) {
        this.victims = victims;
    }
}
