package app.dto.view.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "anomalies")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnomaliesExportXmlDto {
    @XmlElement(name = "anomaly")
    private List<AnomalyExportXmlDto> anomalies;

    public List<AnomalyExportXmlDto> getAnomalies() {
        return anomalies;
    }

    public void setAnomalies(List<AnomalyExportXmlDto> anomalies) {
        this.anomalies = anomalies;
    }
}
