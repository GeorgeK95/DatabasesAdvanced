package app.terminal;

import app.dto.bindings.json.BranchImportJsonDto;
import app.dto.bindings.json.EmployeeCardImportJsonDto;
import app.dto.bindings.json.TownImportJsonDto;
import app.dto.bindings.xml.EmployeeImportXmlDto;
import app.dto.bindings.xml.EmployeesImportXmlDto;
import app.dto.bindings.xml.ProductImportXmlDto;
import app.dto.bindings.xml.ProductsImportXmlDto;
import app.dto.views.json.EmployeeExportJsonDto;
import app.dto.views.xml.BranchesExportXmlDto;
import app.dto.views.xml.TownsExportXmlDto;
import app.entities.EmployeeCard;
import app.serialize.api.Serializer;
import app.services.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Terminal implements CommandLineRunner {

    private static final String OBJECT_INPUT_JSON = "/files/input/json/";
    private static final String OBJECT_OUTPUT_JSON = "src/main/resources/files/output/json/";

    private static final String OBJECT_INPUT_XML = "/files/input/xml/";
    private static final String OBJECT_OUTPUT_XML = "src/main/resources/files/output/xml/";

    @Autowired
    @Qualifier("JsonSerializer")
    private Serializer jsonSerializer;

    @Autowired
    @Qualifier("XmlSerializer")
    private Serializer xmlSerializer;

    @Autowired
    private TownService townService;
    @Autowired
    private BranchService branchService;
    @Autowired
    private EmployeeCardService employeeCardService;
    @Autowired
    private ProductService productService;
    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... strings) throws Exception {
//        import data
        this.importTowns();
        this.importBranches();
        this.importEmployeeCards();
        this.importProducts();
        this.importEmployees();
//        export data
        this.freeCards();
        this.productiveEmployees();
        this.townClients();
        this.topBranches();
    }

    private void topBranches() {
        List<Object[]> topBranches = branchService.topBranches();
        BranchesExportXmlDto wrapper = branchService.getTopBranches(topBranches);
        xmlSerializer.serialize(wrapper, OBJECT_OUTPUT_XML + "top-branches.xml");
    }

    private void townClients() {
        List<Object[]> foundTowns = townService.townClients();
        TownsExportXmlDto wrapper = townService.getTotalClients(foundTowns);
        xmlSerializer.serialize(wrapper, OBJECT_OUTPUT_XML + "towns.xml");
    }


    private void productiveEmployees() {
        List<Object[]> employees = employeeService.productiveEmployees();
        List<EmployeeExportJsonDto> productiveEmployees = employeeService.getProductiveEmployees(employees);
        jsonSerializer.serialize(productiveEmployees, OBJECT_OUTPUT_JSON + "productive-employees.json");
    }

    private void freeCards() {
        List<EmployeeCard> cardsWithoutEmployee = (List<EmployeeCard>) employeeCardService.findByEmployeeNullOrderByIdAsc();
        List<EmployeeCard> dtos = employeeService.freeCards(cardsWithoutEmployee);
        jsonSerializer.serialize(dtos, OBJECT_OUTPUT_JSON + "free-cards.json");
    }

    private void importEmployees() {
        String path = OBJECT_INPUT_XML + "employees.xml";
        EmployeesImportXmlDto employeesImportXmlDto = xmlSerializer.deserialize(EmployeesImportXmlDto.class, path);
        for (EmployeeImportXmlDto currentEmployeeDto : employeesImportXmlDto.getEmployees()) {
            try {
                employeeService.persist(currentEmployeeDto);
                String outputString = currentEmployeeDto.getFirstName() + " " + currentEmployeeDto.getLastName();
                this.printSuccessDataInsert("Employee", outputString);
            } catch (IllegalArgumentException e) {
                this.printError();
            }
        }
    }

    private void importProducts() {
        String path = OBJECT_INPUT_XML + "products.xml";
        ProductsImportXmlDto productDto = xmlSerializer.deserialize(ProductsImportXmlDto.class, path);
        for (ProductImportXmlDto currentProduct : productDto.getProducts()) {
            try {
                productService.persist(currentProduct);
                this.printSuccessDataInsert("Product", currentProduct.getName());
            } catch (IllegalArgumentException e) {
                this.printError();
            }
        }
    }

    private void importEmployeeCards() {
        String path = OBJECT_INPUT_JSON + "employee_cards.json";
        EmployeeCardImportJsonDto[] townImportJsonDto = jsonSerializer.deserialize(EmployeeCardImportJsonDto[].class, path);
        for (EmployeeCardImportJsonDto currentJson : townImportJsonDto) {
            try {
                employeeCardService.persist(currentJson);
                this.printSuccessDataInsert("Employee Card", currentJson.getNumber());
            } catch (IllegalArgumentException e) {
                this.printError();
            }
        }
    }

    private void importBranches() {
        String path = OBJECT_INPUT_JSON + "branches.json";
        BranchImportJsonDto[] townImportJsonDto = jsonSerializer.deserialize(BranchImportJsonDto[].class, path);
        for (BranchImportJsonDto currentJson : townImportJsonDto) {
            try {
                branchService.persist(currentJson);
                this.printSuccessDataInsert("Branch", currentJson.getName());
            } catch (IllegalArgumentException e) {
                this.printError();
            }
        }
    }

    private void importTowns() {
        String path = OBJECT_INPUT_JSON + "towns.json";
        TownImportJsonDto[] townImportJsonDto = jsonSerializer.deserialize(TownImportJsonDto[].class, path);
        for (TownImportJsonDto currentJson : townImportJsonDto) {
            try {
                townService.persist(currentJson);
                this.printSuccessDataInsert("Town", currentJson.getName());
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
}
