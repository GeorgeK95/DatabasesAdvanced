package Vehicles;

import java.text.DecimalFormat;

/**
 * Created by George-Lenovo on 7/31/2017.
 */
public class Truck extends BaseVehicle {
    private double fuelConsumption = 1.6;

    protected Truck(double fuelQuantityParam, double fuelConsumptionParam) {
        super(fuelQuantityParam, fuelConsumptionParam + 1.6);
    }

    @Override
    public void drive(double distance) {
        double available = this.getFuelQuantity() * this.getFuelConsumption();
        double needToTravel = distance * this.getFuelConsumption();
        if (this.getFuelQuantity() - needToTravel < 0) {
            System.out.println("Truck needs refueling");
        } else {
            DecimalFormat df = new DecimalFormat("0.#");
            System.out.println("Truck travelled " + this.fmt(distance) + " km");
            this.setFuelQuantity(this.getFuelQuantity() - needToTravel);
        }
    }
    public String fmt(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }
    @Override
    public void refuel(double liters) {
        super.refuel(liters * 0.95);
    }
}
