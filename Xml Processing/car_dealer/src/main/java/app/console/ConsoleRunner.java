package app.console;

import app.classes.Discount;
import app.dao.DTOConvertUtil;
import app.dto.*;
import app.entities.*;
import app.serialize.XmlParser;
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
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Component
public class ConsoleRunner implements CommandLineRunner {

    private static final String EXPORT_PATH = "C:\\Users\\George-Lenovo\\Desktop\\Projects\\Xml Processing\\car_dealer\\src\\main\\resources\\files\\output\\xml\\";
    private static final String IMPORT_PATH = "/files/input/xml/";

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
    public void run(String... strings) throws ParseException, IOException {
//        seedData(); //3
//        carDealerQueryAndExportData(); //4
    }

    private void carDealerQueryAndExportData() throws IOException {
        orderedCustomers(); //4.1
        carFromMakeToyota(); //4.2
        localSuppliers(); //4.3
        carsWithTheirListOfParts(); //4.4
        totalSalesByCustomer(); //4.5
        salesWithAppliedDiscount(); //4.6

    }

    private void salesWithAppliedDiscount() throws IOException {
        List<Object[]> sales = saleService.salesWithAppliedDiscount();
        Set<SaleDto> saleDtos = new HashSet<>();
        for (Object[] sale : sales) {
            SaleDto dto = getSaleDto(sale);
            saleDtos.add(dto);
        }

        SalesDto salesDto = new SalesDto();
        salesDto.setSales(saleDtos);
        XmlParser xml = new XmlParser();
        String fileName = EXPORT_PATH + "sales-discounts.xml";
        xml.serialize(salesDto, fileName);
    }

    private SaleDto getSaleDto(Object[] sale) {
        SaleDto dto = new SaleDto();
        Car c = generateCar(sale[0], sale[1], sale[2]);
        dto.setCar(DTOConvertUtil.convert(c, CarDto.class));
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

    private void carsWithTheirListOfParts() {
        CarsDto carsDto = new CarsDto();
        List<Car> all = carService.findAll();
        List<CarDto> carDtoSet = new ArrayList<>();
        for (Car car : all) {
            CarDto carDto = DTOConvertUtil.convert(car, CarDto.class);
            PartsDto partsDto = new PartsDto();
            Set<PartDto> parts = partToPartDto(car.getParts());
            partsDto.setParts(parts);
            carDto.setParts(partsDto);
            carDtoSet.add(carDto);
        }

        carsDto.setCars(carDtoSet);
        XmlParser p = new XmlParser();
        String fileName = EXPORT_PATH + "cars-and-parts.xml";
        p.serialize(carsDto, fileName);

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

    private SaleDto makeSaleDto(Object[] object) {
        SaleDto s = new SaleDto();
        Car c = new Car();
        c.setMake(object[0].toString());
        c.setModel(object[1].toString());
        c.setTravelledDistance(BigDecimal.valueOf(Double.valueOf(object[2].toString())));
        return s;
    }

    private void totalSalesByCustomer() {
        List<Customer> objects = customerService.totalSalesByCustomer();
        List<CustomerDto> list = new ArrayList<>();
        for (Customer customer : objects) {
            CustomerDto c = new CustomerDto();
            c.setName(customer.getName());
            c.setBoughtCars((long) customer.getSales().size());
            c.setSpentMoney(getSpentMoney(customer));
            list.add(c);
        }

        String fileName = EXPORT_PATH + "customers-total-sales.xml";
        XmlParser xml = new XmlParser();
        CustomersDto customersDto = new CustomersDto();
        customersDto.setCustomerDtos(list);
        xml.serialize(customersDto, fileName);
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

    private void localSuppliers() {
        List<Supplier> allSupplierByIsImportedFalse = supplierService.findAllSupplierByIsImportedFalse();
        List<SupplierDto> supplierDtos = new ArrayList<>();
        for (Supplier supplier : allSupplierByIsImportedFalse) {
            SupplierDto convert = DTOConvertUtil.convert(supplier, SupplierDto.class);
            convert.setPartsCount(supplier.getParts().size());
            supplierDtos.add(convert);
        }
        SuppliersDto suppliersDto = new SuppliersDto();
        suppliersDto.setSupplier(supplierDtos);
        XmlParser parser = new XmlParser();
        String fileName = EXPORT_PATH + "local-suppliers.xml";
        parser.serialize(suppliersDto, fileName);
    }

    private void carFromMakeToyota() {
        Set<Car> cars = carService.toyotaCars();
        String fileName = EXPORT_PATH + "toyota-cars.xml";
        List<CarDto> carDtos = new ArrayList<>();
        for (Car current : cars) {
            carDtos.add(DTOConvertUtil.convert(current, CarDto.class));
        }

        CarsDto carsDto = new CarsDto();
        carsDto.setCars(carDtos);
        XmlParser parser = new XmlParser();
        parser.serialize(carsDto, fileName);
    }

    private void orderedCustomers() {
        List<Customer> customers = customerService.orderedCustomers();
        String fileName = EXPORT_PATH + "ordered-customers.xml";
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            customerDtos.add(DTOConvertUtil.convert(customer, CustomerDto.class));
        }

        CustomersDto customersDto = new CustomersDto();
        customersDto.setCustomerDtos(customerDtos);
        XmlParser parser = new XmlParser();
        parser.serialize(customersDto, fileName);
    }

    private void seedData() throws ParseException {
        suppliers();
        parts();
        cars();
        customers();
        sales();
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

    private void customers() throws ParseException {
        String fileName = IMPORT_PATH + "customers.xml";
        List<Customer> set = new ArrayList<>();
        XmlParser xml = new XmlParser();
        List<CustomerDto> suppliers = xml.deserialize(CustomersDto.class, fileName).getCustomerDtos().stream().collect(Collectors.toList());

        for (CustomerDto current : suppliers) {
            Customer cc = makeCustomer(current);
            set.add(cc);
        }

        customerService.saveList(set);
    }

    private Customer makeCustomer(CustomerDto current) throws ParseException {
        Customer c = new Customer();
        c.setName(current.getName());
//        List<Sale> l = new ArrayList<>();
//        Set<SaleDto> sales = current.getSales();
//        for (SaleDto saleDto : sales) {
//            l.add(DTOConvertUtil.convert(saleDto, Sale.class));
//        }
//        c.setSales(l.stream().collect(Collectors.toSet()));
//        c.setYoungDriver(current.isYoungDriver());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
//        Date date = sdf.parse(current.getBirthDate());
//        c.setBirthDate(date);
        return c;
    }

    private void cars() {
        String fileName = IMPORT_PATH + "cars.xml";
        XmlParser xml = new XmlParser();
        List<CarDto> suppliers = xml.deserialize(CarsDto.class, fileName).getCars().stream().collect(Collectors.toList());

        for (CarDto car : suppliers) {
            Car c = saveCar(car);
        }

    }

    private Car saveCar(CarDto car) {
        ModelMapper mp = new ModelMapper();
        Car c = mp.map(car, Car.class);
        Set<Part> parts = generateSetOfParts();
        c.setParts(parts);
        carService.save(c);
        return c;
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

    public int generateRandomNumber(int max) {
        Random rand = new Random();
        int i = rand.nextInt(max);
        if (i == 0) {
            i = 1;
        }
        return i;
    }

    public int generateRandomCount(int min, int max) {
        Random rand = new Random();
        int count = rand.nextInt(max);
        if (count < min) {
            count += min;
        }
        return count;
    }

    private void parts() {
        String fileName = IMPORT_PATH + "parts.xml";
        XmlParser xml = new XmlParser();
        List<PartDto> parts = xml.deserialize(PartsDto.class, fileName).getParts().stream().collect(Collectors.toList());
        List<Part> set = new ArrayList<>();

        for (PartDto part : parts) {
            Part p = makePart(part);
            set.add(p);
        }

        partService.saveList(set);
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

    private void suppliers() {
        XmlParser xmlParser = new XmlParser();
        String fileName = IMPORT_PATH + "suppliers.xml";
        List<SupplierDto> deserialize = xmlParser.deserialize(SuppliersDto.class, fileName).getSupplier();
        List<Supplier> suppliers = new ArrayList<>();
        for (SupplierDto supplierDto : deserialize) {
            suppliers.add(DTOConvertUtil.convert(supplierDto, Supplier.class));
        }
        supplierService.saveList(suppliers);
    }

}