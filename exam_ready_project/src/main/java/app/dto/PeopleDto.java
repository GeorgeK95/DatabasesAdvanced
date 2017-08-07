package app.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "people")
//@XmlAccessorType(XmlAccessType.FIELD)
public class PeopleDto {

    private List<PersonDto> personDtos;

    @XmlElement(name = "person")
    public List<PersonDto> getPersonDtos() {
        return personDtos;
    }

    public void setPersonDtos(List<PersonDto> personDtos) {
        this.personDtos = personDtos;
    }
}
