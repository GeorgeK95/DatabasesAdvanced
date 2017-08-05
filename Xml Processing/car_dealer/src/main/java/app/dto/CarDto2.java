package app.dto;

import com.google.gson.annotations.Expose;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public class CarDto2 {
    @Expose
    private CarDto car;

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }
}
