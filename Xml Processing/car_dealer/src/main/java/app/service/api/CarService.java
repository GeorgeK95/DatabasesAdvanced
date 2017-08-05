package app.service.api;

import java.util.Set;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
public interface CarService<Car,Long> extends ServiceInterface<Car,Long> {
    Set<Car> toyotaCars();
}
