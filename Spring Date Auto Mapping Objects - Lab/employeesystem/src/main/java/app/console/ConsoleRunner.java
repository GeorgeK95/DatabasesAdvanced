package app.console;

import app.dto.EmployeeDto;
import app.dto.ManagerDto;
import app.model.Address;
import app.model.Employee;
import app.service.api.AddressService;
import app.service.api.EmployeeService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/28/2017.
 */
@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private EmployeeService<Employee, Long> employeeService;
    @Autowired
    private AddressService<Address, Long> addressService;

    @Override
    public void run(String... strings) throws Exception {
//        task_1();
//        task_2();
        task_3();
    }

    private void task_3() {
        seedData();
        List<Employee> employeesByBirthDayBefore = employeeService.findEmployeesByBirthDayBefore(new Date(1990, 01, 01));
        mapToDto(employeesByBirthDayBefore);
    }

    private void mapToDto(List<Employee> employeesByBirthDayBefore) {
        for (Employee employee : employeesByBirthDayBefore) {
            ModelMapper modelMapper = new ModelMapper();
            PropertyMap<Employee, EmployeeDto> propertyMap = new PropertyMap<Employee, EmployeeDto>() {
                @Override
                protected void configure() {
                    map().setManagerLastName(source.getManager().getLastName());
                }
            };
            modelMapper.addMappings(propertyMap);
            EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
            System.out.printf("%s %s %.2f", employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getSalary());
            if (employeeDto.getManagerLastName() != null) {
                System.out.printf(" - Manager: %s", employeeDto.getManagerLastName());
            } else {
                System.out.print(" [no manager]");
            }
            System.out.println();
        }
    }

    private void seedData() {
        Employee conte = new Employee();
        conte.setFirstName("Antonio");
        conte.setLastName("Conte");
        Employee mou = new Employee();
        mou.setFirstName("Jose");
        mou.setLastName("Mourinho");

        employeeService.save(conte);
        employeeService.save(mou);

        Set<Employee> chelseaPlayers = makeChelseaSet(conte);
        Set<Employee> manUntPlayers = makeManUntSet(mou);
        persistDate(chelseaPlayers, manUntPlayers);

    }

    private void persistDate(Set<Employee> chelsePlayers, Set<Employee> manUntPlayers) {
        for (Employee chelsePlayer : chelsePlayers) {
            employeeService.save(chelsePlayer);
        }
        for (Employee manUntPlayer : manUntPlayers) {
            employeeService.save(manUntPlayer);
        }
    }

    private void task_2() {
        Set<EmployeeDto> chelseaPlayers = makeChelseaEmployeeDtoSet();
        ManagerDto conte = makeChelseaManager(chelseaPlayers);
        Set<EmployeeDto> manUntPlayers = makeManUntEmployeeDtoSet();
        ManagerDto mou = makeManUntManager(manUntPlayers);
        print(conte, mou);
    }

    private Set<EmployeeDto> makeChelseaEmployeeDtoSet() {
        Employee drogba = new Employee();
        drogba.setOnHoliday(false);
        drogba.setFirstName("Didier");
        drogba.setLastName("Drogba");
        drogba.setSalary(new BigDecimal(10000));
        drogba.setBirthDay(new Date(1978, 03, 11));
        Address address = new Address();
        address.setAddress("London, Kennedy str.");
        drogba.setAddress(address);

        Employee lamp = new Employee();
        lamp.setFirstName("Frank");
        lamp.setLastName("Lampard");
        lamp.setSalary(new BigDecimal(30000));
        lamp.setBirthDay(new Date(1978, 06, 20));
        Address address1 = new Address();
        address1.setAddress("London, Bush str.");
        lamp.setAddress(address1);
        lamp.setOnHoliday(true);

        Employee hazard = new Employee();
        hazard.setOnHoliday(true);
        hazard.setFirstName("Eden");
        hazard.setLastName("Hazard");
        hazard.setSalary(new BigDecimal(50000));
        hazard.setBirthDay(new Date(1991, 01, 07));
        Address address2 = new Address();
        address2.setAddress("London, Palmer str.");
        hazard.setAddress(address2);

        ModelMapper modelMapper = new ModelMapper();
        EmployeeDto drogbaDto = modelMapper.map(drogba, EmployeeDto.class);
        EmployeeDto lampDto = modelMapper.map(lamp, EmployeeDto.class);
        EmployeeDto hazardDto = modelMapper.map(hazard, EmployeeDto.class);

        return new HashSet<EmployeeDto>() {{
            add(drogbaDto);
            add(lampDto);
            add(hazardDto);
        }};
    }

    private Set<EmployeeDto> makeManUntEmployeeDtoSet() {
        Employee rooney = new Employee();
        rooney.setOnHoliday(false);
        rooney.setFirstName("Wayne");
        rooney.setLastName("Rooner");
        rooney.setSalary(new BigDecimal(45985));
        rooney.setBirthDay(new Date(1985, 10, 24));
        Address address = new Address();
        address.setAddress("London, Kennedy str.");
        rooney.setAddress(address);

        Employee gigs = new Employee();
        gigs.setFirstName("Rayn");
        gigs.setLastName("Giggs");
        gigs.setSalary(new BigDecimal(12312312));
        gigs.setBirthDay(new Date(1973, 11, 29));
        Address address1 = new Address();
        address1.setAddress("London, Bush str.");
        gigs.setAddress(address1);
        gigs.setOnHoliday(true);

        Employee rashford = new Employee();
        rashford.setOnHoliday(true);
        rashford.setFirstName("Marcos");
        rashford.setLastName("Rashford");
        rashford.setSalary(new BigDecimal(444000));
        rashford.setBirthDay(new Date(1997, 10, 31));
        Address address2 = new Address();
        address2.setAddress("London, Palmer str.");
        rashford.setAddress(address2);

        ModelMapper modelMapper = new ModelMapper();
        EmployeeDto rooneyDto = modelMapper.map(rooney, EmployeeDto.class);
        EmployeeDto gigsDto = modelMapper.map(gigs, EmployeeDto.class);
        EmployeeDto rashfordDto = modelMapper.map(rashford, EmployeeDto.class);

        return new HashSet<EmployeeDto>() {{
            add(rooneyDto);
            add(gigsDto);
            add(rashfordDto);
        }};
    }

    private ManagerDto makeManUntManager(Set<EmployeeDto> manUntPlayers) {
        ManagerDto mou = new ManagerDto();
        mou.setFirstName("Jose");
        mou.setLastName("Mourinho");
        mou.setManaged(manUntPlayers);
        return mou;
    }

    private ManagerDto makeChelseaManager(Set<EmployeeDto> chelsePlayers) {
        ManagerDto conte = new ManagerDto();
        conte.setFirstName("Antonio");
        conte.setLastName("Conte");
        conte.setManaged(chelsePlayers);
        return conte;
    }

    private Set<Employee> makeManUntSet(Employee mou) {
        Employee rooney = new Employee();
        rooney.setOnHoliday(false);
        rooney.setFirstName("Wayne");
        rooney.setLastName("Rooner");
        rooney.setSalary(new BigDecimal(45985));
        rooney.setBirthDay(new Date(1985, 10, 24));
        Address address = new Address();
        address.setAddress("London, Kennedy str.");
        addressService.save(address);
        rooney.setAddress(address);

        Employee gigs = new Employee();
        gigs.setFirstName("Rayn");
        gigs.setLastName("Giggs");
        gigs.setSalary(new BigDecimal(12312312));
        gigs.setBirthDay(new Date(1973, 11, 29));
        Address address1 = new Address();
        address1.setAddress("London, Bush str.");
        addressService.save(address1);
        gigs.setAddress(address1);
        gigs.setOnHoliday(true);

        Employee rashford = new Employee();
        rashford.setOnHoliday(true);
        rashford.setFirstName("Marcos");
        rashford.setLastName("Rashford");
        rashford.setSalary(new BigDecimal(444000));
        rashford.setBirthDay(new Date(1997, 10, 31));
        Address address2 = new Address();
        address2.setAddress("London, Palmer str.");
        addressService.save(address2);
        rashford.setAddress(address2);

//        rooney.setManager(mou);
        gigs.setManager(mou);
        rashford.setManager(mou);

        return new HashSet<Employee>() {{
            add(rooney);
            add(gigs);
            add(rashford);
        }};
    }

    private void print(ManagerDto conte, ManagerDto mou) {
        System.out.printf("%s %s | Employees: %d\n", conte.getFirstName(), conte.getLastName(), conte.getManaged().size());
        for (EmployeeDto employeeDto : conte.getManaged()) {
            System.out.printf("- %s %s $%.2f\n", employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getSalary());
        }
        System.out.printf("%s %s | Employees: %d\n", mou.getFirstName(), mou.getLastName(), mou.getManaged().size());
        for (EmployeeDto employeeDto : mou.getManaged()) {
            System.out.printf("- %s %s $%.2f\n", employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getSalary());
        }
    }

    private Set<Employee> makeChelseaSet(Employee conte) {
        Employee drogba = new Employee();
        drogba.setOnHoliday(false);
        drogba.setFirstName("Didier");
        drogba.setLastName("Drogba");
        drogba.setSalary(new BigDecimal(10000));
        drogba.setBirthDay(new Date(1978, 03, 11));
        Address address = new Address();
        address.setAddress("London, Kennedy str.");
        addressService.save(address);
        drogba.setAddress(address);

        Employee lamp = new Employee();
        lamp.setFirstName("Frank");
        lamp.setLastName("Lampard");
        lamp.setSalary(new BigDecimal(30000));
        lamp.setBirthDay(new Date(1978, 06, 20));
        Address address1 = new Address();
        address1.setAddress("London, Bush str.");
        addressService.save(address1);
        lamp.setAddress(address1);
        lamp.setOnHoliday(true);

        Employee hazard = new Employee();
        hazard.setOnHoliday(true);
        hazard.setFirstName("Eden");
        hazard.setLastName("Hazard");
        hazard.setSalary(new BigDecimal(50000));
        hazard.setBirthDay(new Date(1991, 01, 07));
        Address address2 = new Address();
        address2.setAddress("London, Palmer str.");
        addressService.save(address2);
        hazard.setAddress(address2);

//        drogba.setManager(conte);
        lamp.setManager(conte);
        hazard.setManager(conte);

        return new HashSet<Employee>() {{
            add(drogba);
            add(lamp);
            add(hazard);
        }};
    }

    private void task_1() {
        Employee employee = createEmployee();
        ModelMapper modelMapper = new ModelMapper();
        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        System.out.printf("%s %s $%.2f", employeeDto.getFirstName(), employeeDto.getLastName(), employeeDto.getSalary());
    }

    private Employee createEmployee() {
        Employee e = new Employee();
        e.setFirstName("Didier");
        e.setLastName("Drogba");
        e.setSalary(new BigDecimal(10000));
        e.setBirthDay(new Date());
        Address address = new Address();
        address.setAddress("London, Kennedy str.");
        e.setAddress(address);
        return e;
    }
}
