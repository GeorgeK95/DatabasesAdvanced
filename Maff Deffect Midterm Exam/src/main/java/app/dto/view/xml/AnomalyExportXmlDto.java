package app.dto.view.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class AnomalyExportXmlDto {
    @XmlAttribute
    private Long id;
    @XmlAttribute(name = "origin-planet")
    private String originPlanetName;
    @XmlAttribute(name = "teleport-planet")
    private String teleportPlanetName;

    @XmlElement(name = "victim")
    private List<VictimExportXmlDto> victims;

    public String getOriginPlanetName() {
        return originPlanetName;
    }

    public void setOriginPlanetName(String originPlanetName) {
        this.originPlanetName = originPlanetName;
    }

    public String getTeleportPlanetName() {
        return teleportPlanetName;
    }

    public void setTeleportPlanetName(String teleportPlanetName) {
        this.teleportPlanetName = teleportPlanetName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<VictimExportXmlDto> getVictims() {
        return victims;
    }

    public void setVictims(List<VictimExportXmlDto> victims) {
        this.victims = victims;
    }
}
