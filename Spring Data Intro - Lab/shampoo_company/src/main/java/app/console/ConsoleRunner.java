package app.console;

import app.domain.impl.*;
import app.service.impl.BasicIngredient;
import app.service.impl.BasicShampoo;
import app.service.api.BasicIngredientService;
import app.service.api.BasicShampooService;
import app.service.api.ClassicLabelService;
import app.service.api.ProductionBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

        ProductionBatch batch = new ProductionBatch(LocalDate.now(), shampoos);
        shades.setBatch(batch);
        freshNuke.setBatch(batch);
        pinkPanther.setBatch(batch);
        basicShampooService.save(shades);
        basicShampooService.save(pinkPanther);
        basicShampooService.save(freshNuke);


        productionBatchService.save(batch);
    }
}
