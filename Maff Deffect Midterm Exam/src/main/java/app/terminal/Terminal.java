package app.terminal;

import app.dto.PersonDto;
import app.dto.binding.json.*;
import app.dto.binding.xml.AnomaliesImportXmlDto;
import app.dto.binding.xml.AnomalyImportXmlDto;
import app.dto.view.json.AnomalyJsonExportDto;
import app.dto.view.json.PersonJsonExportDto;
import app.dto.view.json.PlanetJsonExportDto;
import app.dto.view.xml.AnomaliesExportXmlDto;
import app.dto.view.xml.AnomalyExportXmlDto;
import app.entities.Anomaly;
import app.entities.Person;
import app.entities.Planet;
import app.serialize.api.Serializer;
import app.services.api.*;
import app.utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private SolarSystemsService solarSystemsService;
    @Autowired
    private StarsService starsService;
    @Autowired
    private PlanetService planetService;
    @Autowired
    private PersonService personService;
    @Autowired
    private AnomalyService anomalyService;

    @Override
    public void run(String... strings) throws Exception {
//        importSolarSystems();
//        importStars();
//        importPlanets();
//        importPersons();
//        importAnomalies();
//        importAnomaliesVictims();
//        importNewAnomalies();
//
//        noOriginPlanets();
//        peopleNotBeenVictims();
//        biggestAnomaly();
//        allAnomalies();
    }

    private void allAnomalies() {
        List<Anomaly> all = anomalyService.findAll();
        List<AnomalyExportXmlDto> anomalyExportXmlDtos = new ArrayList<>();

        for (Anomaly anomaly : all) {
            AnomalyExportXmlDto xmlDto = DTOConverter.convert(anomaly, AnomalyExportXmlDto.class);
            anomalyExportXmlDtos.add(xmlDto);
            System.out.println();
        }

        AnomaliesExportXmlDto anomaliesExportXmlDto = new AnomaliesExportXmlDto();
        anomaliesExportXmlDto.setAnomalies(anomalyExportXmlDtos);
        String fileName = OBJECT_OUTPUT_XML + "anomalies.xml";
        xmlSerializer.serialize(anomaliesExportXmlDto, fileName);
    }

    private void biggestAnomaly() {
        Anomaly anomaly = anomalyService.biggestAnomaly();
        AnomalyJsonExportDto dto = DTOConverter.convert(anomaly, AnomalyJsonExportDto.class);
        dto.setVictimsCount(anomaly.getVictims().size());
        String fileName = OBJECT_OUTPUT_JSON + "anomaly.json";
        List<AnomalyJsonExportDto> dtos = new ArrayList<>();
        dtos.add(dto);
        jsonSerializer.serialize(dtos, fileName);
    }

    private void peopleNotBeenVictims() {
        List<Person> byAnomaliesNull = personService.findByAnomaliesNull();
        List<PersonJsonExportDto> personJsonExportDtos = new ArrayList<>();
        for (Person person : byAnomaliesNull) {
            PersonJsonExportDto dto = DTOConverter.convert(person, PersonJsonExportDto.class);
            personJsonExportDtos.add(dto);
        }
        String fileName = OBJECT_OUTPUT_JSON + "people.json";
        jsonSerializer.serialize(personJsonExportDtos, fileName);
    }

    private void noOriginPlanets() {
        List<Planet> byOriginAnomalyNull = planetService.findByOriginAnomalyNull();
        List<PlanetJsonExportDto> dtos = new ArrayList();
        for (Planet planet : byOriginAnomalyNull) {
            dtos.add(DTOConverter.convert(planet, PlanetJsonExportDto.class));
        }
        String fileName = OBJECT_OUTPUT_JSON + "planets.json";
        jsonSerializer.serialize(dtos, fileName);
    }

    private void importNewAnomalies() {
        String fileName = OBJECT_INPUT_XML + "new-anomalies.xml";
        AnomaliesImportXmlDto anomaliesImportXmlDto = xmlSerializer.deserialize(AnomaliesImportXmlDto.class, fileName);
        for (AnomalyImportXmlDto anomalyImportXmlDto : anomaliesImportXmlDto.getAnomalies()) {
            try {
                anomalyService.persistDto(anomalyImportXmlDto);
                this.printSuccessDataInsert("data.", "");
            } catch (IllegalArgumentException e) {
                this.printError();
            }
        }
    }


    private void importAnomaliesVictims() {
        String fileName = OBJECT_INPUT_JSON + "anomaly-victims.json";
        AnomalyVictimsJsonImportDto[] dtos = jsonSerializer.deserialize(AnomalyVictimsJsonImportDto[].class, fileName);
        for (AnomalyVictimsJsonImportDto dto : dtos) {
            try {
                anomalyService.persistVictims(dto);
                this.printSuccessDataInsert("data.", "");
            } catch (IllegalArgumentException e) {
                this.printError();
            }
        }
    }

    private void importAnomalies() {
        String fileName = OBJECT_INPUT_JSON + "anomalies.json";
        AnomalyJsonImportDto[] jsonImportDtos = jsonSerializer.deserialize(AnomalyJsonImportDto[].class, fileName);
        for (AnomalyJsonImportDto jsonImportDto : jsonImportDtos) {
            try {
                anomalyService.persist(jsonImportDto);
                this.printSuccessDataInsert("data.", "");
            } catch (IllegalArgumentException e) {
                this.printError();
            }

        }
    }

    private void importPersons() {
        String fileName = OBJECT_INPUT_JSON + "persons.json";
        PersonJsonImportDto[] personJsonImportDtos = jsonSerializer.deserialize(PersonJsonImportDto[].class, fileName);
        for (PersonJsonImportDto personJsonImportDto : personJsonImportDtos) {
            try {
                personService.persist(personJsonImportDto);
                this.printSuccessDataInsert("", personJsonImportDto.getName());
            } catch (IllegalArgumentException e) {
                this.printError();
            }
        }
    }

    private void importPlanets() {
        String fileName = OBJECT_INPUT_JSON + "planets.json";
        PlanetJsonImportDto[] deserialized = jsonSerializer.deserialize(PlanetJsonImportDto[].class, fileName);
        for (PlanetJsonImportDto planetJsonImportDto : deserialized) {
            try {
                planetService.persist(planetJsonImportDto);
                this.printSuccessDataInsert("", planetJsonImportDto.getName());
            } catch (IllegalArgumentException e) {
                this.printError();
            }
        }
    }

    private void importStars() {
        String fileName = OBJECT_INPUT_JSON + "stars.json";
        StarJsonImportDto[] importDtos = jsonSerializer.deserialize(StarJsonImportDto[].class, fileName);
        for (StarJsonImportDto importDto : importDtos) {
            try {
                starsService.persist(importDto);
                this.printSuccessDataInsert("", importDto.getName());
            } catch (IllegalArgumentException e) {
                this.printError();
            }
        }
    }

    private void importSolarSystems() {
        String fileName = OBJECT_INPUT_JSON + "solar-systems.json";
        SolarSystemJsonImportDto[] deserialized = jsonSerializer.deserialize(SolarSystemJsonImportDto[].class, fileName);
        for (SolarSystemJsonImportDto solarSystemJsonImportDto : deserialized) {
            try {
                solarSystemsService.persist(solarSystemJsonImportDto);
                this.printSuccessDataInsert("Solar System", solarSystemJsonImportDto.getName());
            } catch (IllegalArgumentException e) {
                this.printError();
            }
        }
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
