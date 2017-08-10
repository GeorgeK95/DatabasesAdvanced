package app.dto;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class PeopleDto {
    @XmlElement(name = "")
    @XmlAttribute(name = "")
    @Expose
    private List<PersonDto> personDtos;


    public List<PersonDto> getPersonDtos() {
        return personDtos;
    }

    public void setPersonDtos(List<PersonDto> personDtos) {
        this.personDtos = personDtos;
    }
}
