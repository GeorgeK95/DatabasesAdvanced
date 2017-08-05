package app.console;

import app.dao.DTOConvertUtil;
import app.dto.*;
import app.entities.Category;
import app.entities.Product;
import app.entities.User;
import app.serialize.XmlParser;
import app.service.api.CategoryService;
import app.service.api.ProductService;
import app.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Component
public class ConsoleRunner implements CommandLineRunner {

    private static final String EXPORT_PATH = "C:\\Users\\George-Lenovo\\Desktop\\Projects\\gamestore\\src\\main\\resources\\files\\output\\xml\\";
    private static final String EXPORT_PATH_LIST = "src/main/resources/files/output/json/products-in-range.xml";
    private static final String IMPORT_PATH = "/files/input/xml/";

    @Autowired
    private UserService<User, Long> userService;
    @Autowired
    private ProductService<Product, Long> productService;
    @Autowired
    private CategoryService<Category, Long> categoryService;

    @Override
    public void run(String... strings) throws JAXBException, IOException {
//        seedDatabase();
        queryAndExportData();
    }

    private void queryAndExportData() {
//        productsInRange();
//        successfullySoldProducts();
//        categoriesByProductsCount();
        usersAndProducts();
    }

    private void usersAndProducts() {
        Set<User> users = userService.usersAndProducts();
        UsersDto user = new UsersDto();
        user.setCount(users.size());
        List<UserDto> userDtos = new ArrayList<>();
        for (User user1 : users) {
            ProductsDto productsDto = new ProductsDto();
            List<ProductDto> productDtos = new ArrayList<>();
            Set<Product> soldProducts = user1.getSoldProducts();
            for (Product product : soldProducts) {
                productDtos.add(DTOConvertUtil.convert(product, ProductDto.class));
            }
            productsDto.setProducts(productDtos);
            productsDto.setCount(productDtos.size());
            UserDto ui = DTOConvertUtil.convert(user1, UserDto.class);
            ui.setProducts(productsDto);
            userDtos.add(ui);
        }

        user.setUsers(userDtos);
        XmlParser xml = new XmlParser();
        String fileName = EXPORT_PATH + "users-and-products.xml";
        xml.serialize(user, fileName);
    }

    private void categoriesByProductsCount() {
        Set<Object[]> objects = categoryService.categoriesByProductsCount();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Object[] object : objects) {
            CategoryDto cat = makeCategoryDto(object);
            categoryDtos.add(cat);
        }

        CategoriesDto categoriesDto = new CategoriesDto();
        categoriesDto.setCategories(categoryDtos);
        XmlParser xml = new XmlParser();
        String fileName = EXPORT_PATH + "categories-by-products.xml";
        xml.serialize(categoriesDto, fileName);
    }

    private CategoryDto makeCategoryDto(Object[] o) {
        CategoryDto c = new CategoryDto();
        c.setName(o[0].toString());
        c.setProductsCount(Integer.valueOf(o[1].toString()));
        c.setAveragePrice(BigDecimal.valueOf(Double.valueOf(o[2].toString())));
        c.setTotalRevenue(BigDecimal.valueOf(Double.valueOf(o[3].toString())));
        return c;
    }

    private void successfullySoldProducts() {
        Set<User> foundUsers = userService.successfullySoldProducts();
        List<UserDto> userDtos = new ArrayList<>();

        for (User o : foundUsers) {
            UserDto us = DTOConvertUtil.convert(o, UserDto.class);
            List<Product> soldProducts = o.getSoldProducts().stream().collect(Collectors.toList());
            ProductsDto productsDto1 = new ProductsDto();
            List<ProductDto> productDtos1 = new ArrayList<>();
            for (Product soldProduct : soldProducts) {
                productDtos1.add(DTOConvertUtil.convert(soldProduct, ProductDto.class));
            }
            productsDto1.setProducts(productDtos1);
            us.setProducts(productsDto1);
            userDtos.add(us);
        }

        UsersDto mainU = new UsersDto();
        mainU.setUsers(userDtos);
        XmlParser xml = new XmlParser();
        String fileName = EXPORT_PATH + "users-sold-products.xml";
        xml.serialize(mainU, fileName);
    }

    private void productsInRange() {
        Set<Object[]> products = productService.productsInRange();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Object[] o : products) {
            ProductDto prod = new ProductDto();
            prod.setName(o[0].toString());
            prod.setPrice(new BigDecimal(o[1].toString()));
            productDtos.add(prod);
        }

        ProductsDto mainProduct = new ProductsDto();
        mainProduct.setProducts(productDtos);
        XmlParser xml = new XmlParser();
        String fileName = EXPORT_PATH + "products-in-range.xml";
        xml.serialize(mainProduct, fileName);
    }


    private void seedDatabase() throws JAXBException, IOException {
//        users();
//        products();
//        categories();
//        categoriesProductsTable();
//        setBuyersToProducts();
    }

    private void setBuyersToProducts() {
        List<Product> all = productService.findAll();
        for (Product product : all) {
            product.setBuyer(generateRandomBuyer());
        }
        productService.saveList(all);
    }

    private void categoriesProductsTable() {
        for (int i = 1; i <= 11; i++) {
            Category cat = categoryService.findById((long) i);
            cat.setProducts(generateRandomProducts());
            categoryService.save(cat);
        }
    }

    private Set<Product> generateRandomProducts() {
        Random c = new Random();
        int count = c.nextInt(5);


        Set<Product> products = new HashSet<>();
        for (int i = 0; i < count; i++) {
            int productId = c.nextInt(201);
            if (productId == 0) {
                productId = 1;
            }
            products.add(productService.findById((long) productId));
        }
        return products;
    }

    private void categories() {
        String fileName = IMPORT_PATH + "categories.xml";
        XmlParser xmlParser = new XmlParser();
        List<CategoryDto> cats = xmlParser.deserialize(CategoriesDto.class, fileName).getCategories();

        for (CategoryDto p : cats) {
            Category newCat = DTOConvertUtil.convert(p, Category.class);
            categoryService.save(newCat);
        }
    }

    private void products() {
        String fileName = IMPORT_PATH + "products.xml";
        XmlParser xmlParser = new XmlParser();
        List<ProductDto> products = xmlParser.deserialize(ProductsDto.class, fileName).getProducts();

        for (ProductDto p : products) {
            Product prod = DTOConvertUtil.convert(p, Product.class);
            prod.setSeller(generateRandomBuyer());
            prod.setBuyer(generateRandomBuyer());
            productService.save(prod);
        }
    }

    private User generateRandomBuyer() {
        Random rand = new Random();
        int nullProb = rand.nextInt(5);
        if (nullProb == 1) {
            return null;
        }
        int num = rand.nextInt(57);
        if (num == 0) {
            num += 1;
        }
        return userService.findById((long) num);
    }


    private void users() throws JAXBException, IOException {
        String fileName = IMPORT_PATH + "users.xml";
        XmlParser xmlParser = new XmlParser();
        List<UserDto> users = xmlParser.deserialize(UsersDto.class, fileName).getUsers();

        for (UserDto user : users) {
            User u = DTOConvertUtil.convert(user, User.class);
            userService.save(u);
        }
    }

}