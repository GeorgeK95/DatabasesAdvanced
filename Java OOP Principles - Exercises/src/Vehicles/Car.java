package Vehicles;

/**
 * Created by George-Lenovo on 7/31/2017.
 */
public class Car extends BaseVehicle {

    protected Car(double fuelQuantityParam, double fuelConsumptionParam) {
        super(fuelQuantityParam, fuelConsumptionParam + 0.9);
    }
}
