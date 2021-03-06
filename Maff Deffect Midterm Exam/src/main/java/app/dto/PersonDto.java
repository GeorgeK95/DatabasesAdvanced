package app.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.*;
import java.util.Set;


@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonDto {

    @Expose
    @XmlElement(name = "first_name")
    private String firstName;

    @Expose
    @SerializedName("asddasdas")
//    @SerializedName(value = "phoneJsonDtos")
    @XmlElementWrapper(name = "phone_numbers")
    @XmlElement(name = "phone_number")
    private Set<PersonDto> phoneNumbers;

//    @XmlTransient
}
