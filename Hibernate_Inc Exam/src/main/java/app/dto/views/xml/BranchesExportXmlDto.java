package app.dto.views.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "branches")
@XmlAccessorType(XmlAccessType.FIELD)
public class BranchesExportXmlDto {
    @XmlElement(name = "branch")
    private List<BranchExportXmlDto> branches;

    public List<BranchExportXmlDto> getBranches() {
        return branches;
    }

    public void setBranches(List<BranchExportXmlDto> branches) {
        this.branches = branches;
    }
}
