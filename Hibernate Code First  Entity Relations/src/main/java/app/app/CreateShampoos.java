package app.app;

import app.service.api.shampoo.ShampooService;
import app.service.impl.shampoo.BasicShampoo;
import app.domain.shampoo.ProductionBatch;
import app.domain.shampoo.FiftyShades;
import app.domain.shampoo.FreshNuke;
import app.domain.shampoo.PinkPanther;
import app.service.impl.shampoo.shampooServicesImpl.FiftyShadesServiceImpl;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/19/2017.
 */
public class CreateShampoos {
    private static ShampooService<FiftyShades, Long> fiftyShades = new FiftyShadesServiceImpl();
//    private static FreshNukeService<FreshNuke, Long> freshNukeService = new FreshNukeServiceImpl();
//    private static ShampooService<PinkPanther, Long> pinkPantherService = new PinkPantherServiceImpl();

    public static void main(String[] args) {
        FiftyShades shades = new FiftyShades();
        FreshNuke freshNuke = new FreshNuke();
        PinkPanther pinkPanther = new PinkPanther();

        Set<BasicShampoo> shampoos = new HashSet<BasicShampoo>() {{
            add(shades);
            add(freshNuke);
            add(pinkPanther);
        }};

        ProductionBatch batch = new ProductionBatch(LocalDate.now(), shampoos);

        shades.setBatch(batch);
        freshNuke.setBatch(batch);
        pinkPanther.setBatch(batch);

        fiftyShades.save(shades);

    }
}
