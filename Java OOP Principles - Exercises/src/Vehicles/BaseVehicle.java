package Vehicles;

import java.text.DecimalFormat;

/**
 * Created by George-Lenovo on 7/31/2017.
 */
public abstract class BaseVehicle implements Vehicle {

    private double fuelConsumption;
    private double fuelQuantity;

    protected BaseVehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public void drive(double distance) {
        double available = this.getFuelQuantity() * this.getFuelConsumption();
        double needToTravel = distance * this.getFuelConsumption();
        if (available - needToTravel < 0) {
            System.out.println("Car needs refueling");
        } else {
            DecimalFormat df = new DecimalFormat("###.#");
            System.out.println("Car travelled " + this.fmt(distance) + " km");
            this.fuelQuantity -= needToTravel;
        }
    }

    public String fmt(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }

    @Override
    public double getFuelQuantity() {
        return this.fuelQuantity;
    }


    @Override
    public double getFuelConsumption() {
        return fuelConsumption;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    private void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

}
