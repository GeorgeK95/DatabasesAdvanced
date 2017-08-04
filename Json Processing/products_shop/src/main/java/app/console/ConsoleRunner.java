package app.console;

import app.dto.*;
import app.entities.Category;
import app.entities.Product;
import app.entities.User;
import app.io.JsonParser;
import app.service.api.CategoryService;
import app.service.api.ProductService;
import app.service.api.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Component
public class ConsoleRunner implements CommandLineRunner {
    private static final String EXPORT_PATH = "C:\\Users\\George-Lenovo\\Desktop\\Projects\\Json Processing\\src\\main\\resources\\files\\output\\json\\";//src/main/resources/files/output/json/

    private static final String IMPORT_USERS_PATH = "/files/input/json/users.json";
    private static final String IMPORT_PRODUCTS_PATH = "/files/input/json/products.json";
    private static final String IMPORT_CATEGORIES_PATH = "/files/input/json/categories.json";

    @Autowired
    private UserService<User, Long> userService;
    @Autowired
    private ProductService<Product, Long> productService;
    @Autowired
    private CategoryService<Category, Long> categoryService;

    @Override
    public void run(String... strings) {
        //1
//        importUsers();
//        importProducts();
//        importCategories();
        //2
//        seedCategoryProductsTable();
        //3
//        queryAndExportData();
    }

    private void queryAndExportData() {
        //3.1
//        productsInRange();
        //3.2
//        successfullySoldProducts();
        //3.3
//        categoriesByProductsCount();
        //3.4
        usersAndProducts();
    }

    private void usersAndProducts() {
        JsonParser jsonParser = new JsonParser();
        try {
            Set<User> found = userService.usersAndProducts();
            UsersProductsDto usersProductsDto = new UsersProductsDto();
            usersProductsDto.setUsersCount(found.size());
            List<UserDto> usersDto = new ArrayList<>();

            for (User current : found) {
                UserDto userDto = makeUserDto(current);
                usersDto.add(userDto);
            }

            usersProductsDto.setUsers(usersDto);

            String fileName = EXPORT_PATH + "users-and-products.json";
            jsonParser.exportJson(usersProductsDto, fileName);
        } catch (IOException e) {
            System.out.println("Failed to export json.");
            e.printStackTrace();
        }
    }

    private UserDto makeUserDto(User current) {
        UserDto result = makeUser(current);
        return result;
    }

    private void categoriesByProductsCount() {
        JsonParser jsonParser = new JsonParser();
        try {
            Set<Object[]> found = categoryService.categoriesByProductsCount();
            List<CategoryDto> categoryDtos = new ArrayList<>();
            for (Object[] o : found) {
                CategoryDto categoryDto = makeCategoryDto(o);
                categoryDtos.add(categoryDto);
            }
            String fileName = EXPORT_PATH + "categories-by-products.json";
            jsonParser.exportJson(categoryDtos, fileName);
        } catch (IOException e) {
            System.out.println("Failed to export json.");
            e.printStackTrace();
        }
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
        String fileName = EXPORT_PATH + "users-sold-products.json";
        writeInFile2(foundUsers, fileName);
    }

    private void writeInFile2(Set<User> products, String fileName) {
        JsonParser jsonParser = new JsonParser();
        try {
            List<UserDto> userDtos = new ArrayList<>();
            for (User o : products) {
                UserDto prod = makeUser(o);
                userDtos.add(prod);
            }
            jsonParser.exportJson(userDtos, fileName);
        } catch (IOException e) {
            System.out.println("Failed to export json.");
            e.printStackTrace();
        }
    }

    private UserDto makeUser(User o) {
        UserDto u = new UserDto();
        u.setFirstName(o.getFirstName());
        u.setLastName(o.getLastName());
        u.setAge(o.getAge());

        Set<Product> set = o.getSoldProducts();//.stream().filter(x -> x.getBuyer() != null).collect(Collectors.toSet());
        Set<ProductDto> productDtos = new HashSet<>();
        for (Product p : set) {
            ProductDto productDto = new ProductDto();
            productDto.setPrice(p.getPrice());
            productDto.setName(p.getName());
            productDtos.add(productDto);
        }
        SoldProductsDto t = new SoldProductsDto();
        t.setSoldProductsCount(productDtos.size());
        t.setSoldProducts(productDtos);

        u.setSoldProducts(t);
        return u;
    }

    private void productsInRange() {
        Set<Object[]> products = productService.productsInRange();
        String fileName = EXPORT_PATH + "products-in-range.json";
        writeInFile(products, fileName);
    }

    private void writeInFile(Set<Object[]> products, String fileName) {
        JsonParser jsonParser = new JsonParser();
        try {
            List<ProductDto> productDtos = new ArrayList<>();
            for (Object[] o : products) {
                ProductDto prod = new ProductDto();
                prod.setName(o[0].toString());
                prod.setPrice(new BigDecimal(o[1].toString()));
                productDtos.add(prod);
            }
            jsonParser.exportJson(productDtos, fileName);
        } catch (IOException e) {
            System.out.println("Failed to export json.");
            e.printStackTrace();
        }
    }

    private void seedCategoryProductsTable() {
        for (int i = 1; i <= 11; i++) {
            Category cat = categoryService.findById((long) i);
            cat.setProducts(generateRandomProducts());
            categoryService.save(cat);
        }
    }

    private void importCategories() {
        JsonParser jsonParser = new JsonParser();
        try {
            CategoryDto[] categoryDtos = jsonParser.importJson(CategoryDto[].class, IMPORT_CATEGORIES_PATH);
            ModelMapper mp = new ModelMapper();
            List<Category> categories = new ArrayList<>();
            for (CategoryDto dto : categoryDtos) {
                Category newcat = mp.map(dto, Category.class);
                categories.add(newcat);
            }
            categoryService.saveList(categories);
        } catch (IOException e) {
            System.out.println("Failed to import json.");
            e.printStackTrace();
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

    private void importProducts() {
        JsonParser jsonParser = new JsonParser();
        try {
            ProductDto[] productDtos = jsonParser.importJson(ProductDto[].class, IMPORT_PRODUCTS_PATH);
            ModelMapper mp = new ModelMapper();
            List<Product> products = new ArrayList<>();
            int c = 0;
            for (ProductDto dto : productDtos) {
                Product newProduct = mp.map(dto, Product.class);
                newProduct.setSeller(generateRandomBuyer());
                if (c % 5 != 0) {
                    newProduct.setBuyer(generateRandomBuyer());
                }
                products.add(newProduct);
                c++;
            }
            productService.saveList(products);
        } catch (IOException e) {
            System.out.println("Failed to import json.");
            e.printStackTrace();
        }
    }

    private User generateRandomBuyer() {
        Random rand = new Random();
        int num = rand.nextInt(57);
        if (num == 0) {
            num += 1;
        }
        return userService.findById((long) num);
    }

    private void importUsers() {
        JsonParser jsonParser = new JsonParser();
        try {
            UserDto[] userDto = jsonParser.importJson(UserDto[].class, IMPORT_USERS_PATH);
            ModelMapper mp = new ModelMapper();
            List<User> users = new ArrayList<>();
            for (UserDto dto : userDto) {
                users.add(mp.map(dto, User.class));
            }
            userService.saveList(users);
        } catch (IOException e) {
            System.out.println("Failed to import json.");
            e.printStackTrace();
        }
    }

}