package Vehicles;

/**
 * Created by George-Lenovo on 7/31/2017.
 */
public interface Vehicle {
    double getFuelQuantity();

    double getFuelConsumption();

    void drive(double distance);

    void refuel(double liters);

}
