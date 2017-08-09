package app.terminal;

import app.dto.PersonDto;
import app.serialize.api.Serializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;

@Component
public class Terminal implements CommandLineRunner {

    private static final String OBJECT_INPUT_JSON = "/files/input/json/";
    private static final String OBJECT_OUTPUT_JSON = "src/main/resources/files/output/json/";

    private static final String OBJECT_INPUT_XML = "/files/input/xml/";
    private static final String OBJECT_OUTPUT_XML = "src/main/resources/files/output/xml/";

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


    private void printError() {
        System.out.println("Error: Invalid data.");
    }

    private void printSuccessDataInsert(String type, String name) {
        System.out.printf("Successfully imported %s %s.%n", type, name);
    }

    public void toJson(String filePath) {
//        List<Planet> planets = this.planetRepository.findAllByOrOriginalAnomalyIsNull();
//        List<PlanetExportDto> planetDtos = new ArrayList<>();
//        for (Planet planet : planets) {
//            PlanetExportDto planetDto = new PlanetExportDto();
//            planetDto.setName(planet.getName());
//            planetDtos.add(planetDto);
//        }
//        this.jsonParser.writeToJson(planetDtos,filePath);
    }

    public void toXml(String filePath) throws JAXBException {
//        List<Anomaly> anomalies = this.anomalyRepository.findAll();
//
//        List<AnomalyExportXmlDto> anomalyExportXmlDtos = new ArrayList<>();
//        for (Anomaly anomaly : anomalies) {
//            anomalyExportXmlDtos.add(anomalyExportXmlDto);
//        }
//
//        AnomaliesExportDto anomaliesExportDto = new AnomaliesExportDto();
//        anomaliesExportDto.setAnomalyExportDtos(anomalyExportXmlDtos);
//
//        this.xmlParser.writeToXml(anomaliesExportDto, filePath);
    }

    private void fromXml() {
        PersonDto personDto = xmlSerializer.deserialize(PersonDto.class, OBJECT_INPUT_JSON);
//        DTOConverter.convert(personDto, Person.class);
//        personService.persist(person);
    }

    private void fromJson() {
//        String path = RESOURCES_INPUT_JSON_PATH + "stars.json";
//
//        StarImportDto[] starImportDtos = null;
//        starImportDtos = this.jsonParser.readFromJson(StarImportDto[].class, path);
//
//        for (StarImportDto starImportDto : starImportDtos) {
//            try {
//                this.starService.persist(starImportDto);
//                this.printSuccessDataInsert("Star", starImportDto.getName());
//            } catch (IllegalArgumentException e) {
//                this.printError();
//            }
//        }
    }
}
