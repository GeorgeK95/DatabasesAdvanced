package app.console;

import app.classes.Discount;
import app.dto.*;
import app.entities.*;
import app.io.JsonParser;
import app.service.api.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Component
public class ConsoleRunner implements CommandLineRunner {

    private static final String EXPORT_PATH = "C:\\Users\\George-Lenovo\\Desktop\\Projects\\Json Processing\\car_dealer\\src\\main\\resources\\files\\output\\json\\";
    private static final String IMPORT_PATH = "/files/input/json/";

    @Autowired
    private SupplierService<Supplier, Long> supplierService;
    @Autowired
    private PartService<Part, Long> partService;
    @Autowired
    private CarService<Car, Long> carService;
    @Autowired
    private CustomerService<Customer, Long> customerService;
    @Autowired
    private SaleService<Sale, Long> saleService;

    @Override
    public void run(String... strings) throws ParseException {
//        seedData();
//        orderedCustomers(); //1
//        toyotaCars(); //2
//        localSuppliers(); //3
//        carsWithTHeirListOfParts(); //4
//        totalSalesByCustomer(); //5
//        salesWithAppliedDiscount();
        try {
            test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void test() throws IOException {
        List<Object[]> sales = saleService.salesWithAppliedDiscount();
        JsonParser jsonParser = new JsonParser();
        String fileName = EXPORT_PATH + "sales-discounts.json";
        List<SaleDto> saleDtos = new ArrayList<>();
        for (Object[] sale : sales) {
            SaleDto dto = makeSaleDto(sale);
            saleDtos.add(dto);
        }
        jsonParser.exportJson(saleDtos, fileName);
        int a = 5;
    }

    private SaleDto makeSaleDto(Object[] sale) {
        SaleDto dto = new SaleDto();
        Car car = generateCar(sale[0], sale[1], sale[2]);
        ModelMapper mp = new ModelMapper();

        dto.setCar(mp.map(car, CarDto.class));
        dto.setCustomerName(sale[3].toString());
        dto.setDiscount(BigDecimal.valueOf(Double.valueOf(sale[4].toString())));
        dto.setPrice(BigDecimal.valueOf(Double.valueOf(sale[5].toString())));
        dto.setPriceWithDiscount(BigDecimal.valueOf(Double.valueOf(sale[6].toString())));

        return dto;
    }

    private Car generateCar(Object o, Object o1, Object o2) {
        Car c = new Car();
        c.setMake(o.toString());
        c.setModel(o1.toString());
        c.setTravelledDistance(BigDecimal.valueOf(Double.valueOf(o2.toString())));
        return c;

    }

    private void salesWithAppliedDiscount() {
        List<Sale> allSales = saleService.findAll();
        for (Sale allSale : allSales) {
            ModelMapper mp = new ModelMapper();
            SaleDto map = mp.map(allSale, SaleDto.class);
            int a = 5;
        }

    }

    private void totalSalesByCustomer() {
        Set<Customer> objects = customerService.totalSalesByCustomer();
        List<CustomerDto> list = new ArrayList<>();
        for (Customer customer : objects) {
            CustomerDto c = new CustomerDto();
            c.setName(customer.getName());
            c.setBoughtCars((long) customer.getSales().size());
            c.setSpentMoney(getSpentMoney(customer));
            list.add(c);
        }

        JsonParser jsonParser = new JsonParser();
        String fileName = EXPORT_PATH + "customers-total-sales.json";
        try {
            jsonParser.exportJson(list, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BigDecimal getSpentMoney(Customer customer) {
        BigDecimal total = new BigDecimal(0);
        for (Sale sale : customer.getSales()) {
            for (Part o : sale.getCar().getParts()) {
                total = total.add(o.getPrice());
            }
        }
        return total;
    }

    private void carsWithTHeirListOfParts() {
        String fileName = EXPORT_PATH + "cars-and-parts.json";
        List<Car> allCars = carService.findAll();
//        List<CarDto> dtos = new ArrayList<>();
        List<CarDto2> dtos2 = new ArrayList<>();
        for (Car car : allCars) {
            ModelMapper m = new ModelMapper();
            CarDto map = m.map(car, CarDto.class);
            map.setParts(partToPartDto(car.getParts()));
//            dtos.add(map);
            CarDto2 car2 = new CarDto2();
            car2.setCar(map);
            dtos2.add(car2);
        }
        try {
//            CarDto2 c2 = new CarDto2();
            JsonParser js = new JsonParser();
            js.exportJson(dtos2, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Set<PartDto> partToPartDto(Set<Part> parts) {
        Set<PartDto> partDtos = new HashSet<>();
        for (Part part : parts) {
            ModelMapper m = new ModelMapper();
            PartDto map = m.map(part, PartDto.class);
            partDtos.add(map);
        }
        return partDtos;
    }

    private void localSuppliers() {
        String fileName = EXPORT_PATH + "local-supplies.json";
        List<Supplier> allSupplierByIsImporterFalse = supplierService.findAllSupplierByIsImportedFalse();
        List<SupplierDto> dtos = new ArrayList<>();
        for (Supplier supplier : allSupplierByIsImporterFalse) {
            ModelMapper m = new ModelMapper();
            SupplierDto map = m.map(supplier, SupplierDto.class);
            map.setPartsCount(supplier.getParts().size());
            dtos.add(map);
        }
        try {
            JsonParser js = new JsonParser();
            js.exportJson(dtos, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void toyotaCars() {
        String fileName = EXPORT_PATH + "toyota-cars.json";
        Set<Car> cars = carService.toyotaCars();
        List<CarDto> dtos = new ArrayList<>();
        for (Car car : cars) {
            ModelMapper m = new ModelMapper();
            CarDto map = m.map(car, CarDto.class);
            dtos.add(map);
        }
        try {
            JsonParser js = new JsonParser();
            js.exportJson(dtos, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void orderedCustomers() {
        String fileName = EXPORT_PATH + "ordered-customers.json";
        Set<Customer> customers = customerService.orderedCustomers();
        JsonParser js = new JsonParser();
        List<CustomerDto> dtos = new ArrayList<>();
        for (Customer customer : customers) {
            ModelMapper m = new ModelMapper();
            dtos.add(m.map(customer, CustomerDto.class));
        }
        try {
            js.exportJson(dtos, fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void seedData() throws ParseException {
        supplies();
        parts();
        cars();
        customers();
        sales();
    }

    private void customers() throws ParseException {
        JsonParser parser = new JsonParser();
        String fileName = IMPORT_PATH + "customers.json";
        try {
            CustomerDto[] suppliers = parser.importJson(CustomerDto[].class, fileName);

            for (CustomerDto customerDto : suppliers) {
//                ModelMapper mp = new ModelMapper(); mp.map(customerDto, Customer.class)
                Customer c = new Customer();
                c.setName(customerDto.getName());
                c.setYoungDriver(customerDto.isYoungDriver());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
                sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
                String dateInString = customerDto.getBirthDate();
                Date date = sdf.parse(dateInString);
                c.setBirthDate(date);

                customerService.save(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to import json file.");
        }
    }

    private void sales() {
        for (int i = 0; i < 20; i++) {
            Car car = carService.findById((long) generateRandomNumber(359));
            Customer customer = customerService.findById((long) generateRandomNumber(31));
            int discount = Discount.getRandomDiscount();

            Sale s = new Sale();
            s.setCar(car);
            s.setCustomer(customer);
            s.setDiscount(BigDecimal.valueOf(discount));

            saleService.save(s);
        }
    }

    private void cars() {
        JsonParser parser = new JsonParser();
        String fileName = IMPORT_PATH + "cars.json";
        try {
            CarDto[] suppliers = parser.importJson(CarDto[].class, fileName);
            List<Car> set = new ArrayList<>();

            for (CarDto car : suppliers) {
                Car c = makeCar(car);
                set.add(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to import json file.");
        }
    }

    private Car makeCar(CarDto car) {
        ModelMapper mp = new ModelMapper();
        Car c = mp.map(car, Car.class);
        Set<Part> parts = generateSetOfParts();
        c.setParts(parts);
        carService.save(c);
        return c;
    }

    public int generateRandomCount(int min, int max) {
        Random rand = new Random();
        int count = rand.nextInt(max);
        if (count < min) {
            count += min;
        }
        return count;
    }

    public int generateRandomNumber(int max) {
        Random rand = new Random();
        int i = rand.nextInt(max);
        if (i == 0) {
            i = 1;
        }
        return i;
    }

    private Set<Part> generateSetOfParts() {
        Set<Part> parts = new HashSet<>();
        Set<Long> uniqueIds = new HashSet<>();

        int n = generateRandomCount(10, 20);
        for (int j = 0; j < n; j++) {
            int i = generateRandomNumber(132);
            uniqueIds.add((long) i);
        }
        for (Long uniqueId : uniqueIds) {
            Part byId = partService.findById(uniqueId);
            parts.add(byId);
        }

        return parts;
    }

    private void parts() {
        JsonParser parser = new JsonParser();
        String fileName = IMPORT_PATH + "parts.json";
        try {
            PartDto[] suppliers = parser.importJson(PartDto[].class, fileName);
            List<Part> set = new ArrayList<>();

            for (PartDto part : suppliers) {
                Part p = makePart(part);
                set.add(p);
            }

            partService.saveList(set);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to import json file.");
        }
    }

    private Part makePart(PartDto part) {
        ModelMapper mp = new ModelMapper();
        Part p = mp.map(part, Part.class);
        p.setSupplier(generateRandomSupplier());
        return p;
    }

    private Supplier generateRandomSupplier() {
        Random rand = new Random();
        int i = rand.nextInt(32);
        if (i == 0) {
            i = 1;
        }
        return supplierService.findById((long) i);
    }

    private void supplies() {
        JsonParser parser = new JsonParser();
        String fileName = IMPORT_PATH + "suppliers.json";
        try {
            SupplierDto[] suppliers = parser.importJson(SupplierDto[].class, fileName);
            List<Supplier> set = new ArrayList<>();
            for (SupplierDto supplier : suppliers) {
                Supplier s = new Supplier();
                s.setName(supplier.getName());
                s.setIsImporter(supplier.isImporter());
                set.add(s);
            }
            supplierService.saveList(set);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to import json file.");
        }
    }

}