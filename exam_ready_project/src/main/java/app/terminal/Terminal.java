package app.terminal;

import app.dto.PersonDto;
import app.serialize.api.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    private static final String OBJECT_INPUT_JSON = "/files/input/json/***.json";
    private static final String OBJECT_OUTPUT_JSON = "src/main/resources/files/input/json/***.json";

    // @SerializedName - when Json name != field name
    // ObjectDto[].class when you have collection in  .json
    // Qualifier - when you have many implementations for autowire

    /*
     if (! DataValidator.checkIsValid(addGame)) {
            return DataValidator.getInvalidParameterMessage(addGame);
        }

     */

    @Autowired
    @Qualifier("JsonSerializer")
    private Serializer jsonSerializer;

    @Autowired
    @Qualifier("XmlSerializer")
    private Serializer xmlSerializer;

    @Override
    public void run(String... strings) throws Exception {
        int a = 5;
    }

//    private void importObject() {
//        jsonSerializer.deserialize(ObjectDTO.class ,OBJECT_INPUT_JSON);
//    }

    private void importPersonXml() {
        PersonDto personDto = xmlSerializer.deserialize(PersonDto.class, OBJECT_INPUT_JSON);
//        DTOConverter.convert(personDto, Person.class);
//        personService.persist(person);
    }
}
