package app.dto.binding.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "anomalies")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnomaliesImportXmlDto {
    @XmlElement(name = "anomaly")
    private List<AnomalyImportXmlDto> anomalies;

    public List<AnomalyImportXmlDto> getAnomalies() {
        return anomalies;
    }

    public void setAnomalies(List<AnomalyImportXmlDto> anomalies) {
        this.anomalies = anomalies;
    }
}
