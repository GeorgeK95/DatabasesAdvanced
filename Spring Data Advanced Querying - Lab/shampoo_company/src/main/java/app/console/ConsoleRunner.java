package app.console;

import app.domain.impl.*;
import app.service.api.BasicIngredientService;
import app.service.api.BasicShampooService;
import app.service.api.ClassicLabelService;
import app.service.api.ProductionBatchService;
import app.service.impl.BasicIngredient;
import app.service.impl.BasicShampoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    private ProductionBatchService<ProductionBatch, Long> productionBatchService;
    @Autowired
    private BasicIngredientService<BasicIngredient, Long> basicIngredientService;
    @Autowired
    private BasicShampooService<BasicShampoo, Long> basicShampooService;
    @Autowired
    private ClassicLabelService<ClassicLabel, Long> classicLabelService;

    @Override
    public void run(String... strings) throws Exception {
//        seedData();
//        findShampoosByBrand(); //1
//        findShampoosByBrandAndSize(); //2
//        findBasicShampoosBySizeOrLabel(); //3
//        findBasicShampoosByPrice(); //4
//        findProductionBatchByDateAfter(); //5
//        findNullPrices(); //6;
//        ingredientByName(); //7
//        ingredientByNames(); //8
//        batchesByShampoos(); //9
//        countShampoosByPrice(); //10
//        shampoosByLabel(); //11
//        ingredientByNames(); //12
//        shampoosByIngredients(); //13
//        shampoosByIngredientsCount(); //14
//        shampoosByBatchDate(); //15
//        shampoosByIngredientsPrice(); //16
//        shampoosByBatchAndLabel(); //17
//        ingredientsBySumOfPrice(); //18
//        ingredientNameShampooBrand(); //19
        batchDateShampooLabel(); //20
//        deleteIngredientByName(); //21
//        increaseIngredientsPrice(); //22
//        updateIngredientsByNames(); //23
    }

    private void batchDateShampooLabel() {
        List<Object[]> found = basicShampooService.findBatchDateAndLabelTitle();
        for (Object[] objects : found) {
            System.out.printf("%s %s\n", objects[0], objects[1]);
        }
    }

    private void deleteIngredientByName() {
        basicIngredientService.deleteIgredientByName("ronaldinho");
    }

    private void ingredientNameShampooBrand() {
        List<Object[]> hopa = basicIngredientService.findNamesAndBrands();
        for (Object[] objects : hopa) {
            System.out.printf("Brand: %s Ingredient: %s\n", objects[0], objects[1]);
        }
    }

    private void ingredientsBySumOfPrice() {
        BigDecimal bd = new BigDecimal(5);
        List<Object[]> a = basicIngredientService.findBySumOfPrice(bd);
        BigDecimal total = new BigDecimal(0);
        for (Object[] objects : a) {
            BigDecimal s = BigDecimal.valueOf(Double.valueOf(objects[1].toString()));
            total = total.add(s);
            System.out.println(objects[1]);
        }

        System.out.printf("Count: %d, Sum of price: %f\n", a.size(), total);
    }

    private void increaseIngredientsPrice() {
        basicIngredientService.increaseIngredientsPrice();
    }

    private void updateIngredientsByNames() {
        List<String> names = new ArrayList<String>() {{
            add("ronaldo");
        }};
        basicIngredientService.updatePricesInNamesList(names);
    }

    private void shampoosByBatchAndLabel() {
        Scanner in = new Scanner(System.in);
        Long id = Long.valueOf(in.nextLine());
        String subTitle = in.nextLine();
        ProductionBatch batch = productionBatchService.findById(id);
        Set<BasicShampoo> result = basicShampooService.findShampoosWithDifferentLabel(subTitle, batch);
        System.out.println("Found count: " + result.size());
    }

    private void shampoosByIngredientsPrice() {
        BigDecimal sumPrice = new BigDecimal(11);
        Set<BasicShampoo> found = basicShampooService.findShampoosByIngredientPrice(sumPrice);
        System.out.println("Found count: " + found.size());
    }

    private void shampoosByBatchDate() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2005-11-10";
        Date date = sdf.parse(dateInString);
        ProductionBatch b = productionBatchService.findProductionBatchByBatchDateBefore(date).get(0);
        Set<BasicShampoo> found = basicShampooService.findBasicShampoosByBatchCount(b);
        System.out.println("Found count: " + found.size());
    }

    private void shampoosByIngredientsCount() {
        Scanner in = new Scanner(System.in);
        int c = Integer.valueOf(in.nextLine());
        Set<BasicShampoo> found = basicShampooService.findShampoosByIngredientsCount(c);
        System.out.println("Found count: " + found.size());
    }

    private void shampoosByIngredients() {
        Set<BasicIngredient> ingredients = basicIngredientService.findBasicIngredientsByNameStartingWith("ronald");
        Set<BasicShampoo> found = basicShampooService.findShampoosByIngredients(ingredients);
        System.out.println("Found count: " + found.size());
    }

    private void shampoosByLabel() {
        Scanner in = new Scanner(System.in);
        String labelSubTitle = in.nextLine();
        List<BasicShampoo> found = basicShampooService.findShampoosByLabel(labelSubTitle);
        System.out.println("Found count: " + found.size());
    }

    private void countShampoosByPrice() {
        Scanner in = new Scanner(System.in);
        String brand = in.nextLine();
        BigDecimal price = BigDecimal.valueOf(Double.valueOf(brand));
        List<BasicShampoo> found = basicShampooService.findBasicShampoosByPriceBefore(price);
        System.out.println("Found count: " + found.size());
    }

    private void batchesByShampoos() {
        List<ProductionBatch> found = productionBatchService.findBasicIngredientsJoinProductionBatchByShampoosNull();
        System.out.println("Found count: " + found.size());
    }

    private void ingredientByNames() {
        Set<String> names = new HashSet<String>() {{
            add("ronaldo");
            add("drogba");
            add("terry");
        }};
        List<BasicIngredient> found = basicIngredientService.findIngredientsByNames(names);
        System.out.println("Found count: " + found.size());
    }

    private void ingredientByName() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Set<BasicIngredient> found = basicIngredientService.findBasicIngredientsByNameStartingWith(line);
        System.out.println("Found count: " + found.size());
    }

    private void findNullPrices() {
        List<BasicIngredient> all = basicIngredientService.findBasicIngredientsByPriceNull();
        System.out.println("Found count: " + all.size());
    }

    private void findProductionBatchByDateAfter() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2002-10-10";
        Date date = sdf.parse(dateInString);

        List<ProductionBatch> found = productionBatchService.findProductionBatchByDateAfter(date);
        System.out.println("Found count: " + found.size());
    }

    private void findBasicShampoosByPrice() {
        Scanner in = new Scanner(System.in);
        String priceStr = in.nextLine();
        BigDecimal price = new BigDecimal(Double.parseDouble(priceStr));
        List<BasicShampoo> found = basicShampooService.findBasicShampoosByPriceAfter(price);
        System.out.println("Found count: " + found.size());
    }

    private void findBasicShampoosBySizeOrLabel() {
        Scanner in = new Scanner(System.in);
        String labelSubTitle = in.nextLine();
        Size size = Size.BIG;
        ClassicLabel label = classicLabelService.findBySubTitle(labelSubTitle);
        List<BasicShampoo> found = basicShampooService.findBasicShampoosBySizeOrLabel(label, size);
        System.out.println("Found count: " + found.size());
    }

    private void findShampoosByBrandAndSize() {
        Scanner in = new Scanner(System.in);
        String brand = in.nextLine();
        Size size = Size.BIG;
        List<BasicShampoo> found = basicShampooService.findBasicShampoosByBrandAndSize(brand, size);
        System.out.println("Found count: " + found.size());
    }

    private void findShampoosByBrand() {
        Scanner in = new Scanner(System.in);
        String brand = in.nextLine();
        List<BasicShampoo> found = basicShampooService.findBasicShampoosByBrand(brand);
        System.out.println("Found count: " + found.size());
    }

    private void seedData() throws ParseException {
        ClassicLabel cl = new ClassicLabel();
        cl.setSubTitle("sub");
        cl.setTitle("tit");
        this.classicLabelService.save(cl);

        BasicIngredient b1 = new Mint();
        basicIngredientService.save(b1);

        BasicShampoo shades = new FiftyShades();
        BasicShampoo freshNuke = new FreshNuke();
        BasicShampoo pinkPanther = new PinkPanther();

        Set<BasicShampoo> shampoos = new HashSet<BasicShampoo>() {{
            add(shades);
            add(freshNuke);
            add(pinkPanther);
        }};

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2001-10-10";
        Date date = sdf.parse(dateInString);

        ProductionBatch batch = new ProductionBatch(date, shampoos);
        shades.setBatch(batch);
        freshNuke.setBatch(batch);
        pinkPanther.setBatch(batch);
        basicShampooService.save(shades);
        basicShampooService.save(pinkPanther);
        basicShampooService.save(freshNuke);


        productionBatchService.save(batch);
    }
}
