package Vehicles;

import java.util.Scanner;

/**
 * Created by George-Lenovo on 7/31/2017.
 */
public class Main {
    private static BaseVehicle car;
    private static BaseVehicle truck;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;

        for (int i = 0; i < 2; i++) {
            line = in.nextLine();
            String[] spl = line.split("\\s+");
            double km = Double.valueOf(spl[1]);
            double cons = Double.valueOf(spl[2]);
            if (i == 0) {
                car = new Car(km, cons);
            } else {
                truck = new Truck(km, cons);
            }
        }

        int n = Integer.valueOf(in.nextLine());
        for (int i = 0; i < n; i++) {
            line = in.nextLine();
            String[] spl = line.split("\\s+");
            switch (spl[0]) {
                case "Drive":
                    drive(spl);
                    break;
                case "Refuel":
                    refuel(spl);
                    break;
            }
        }

        System.out.printf("Car: %.2f\n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f\n", truck.getFuelQuantity());
    }

    private static void refuel(String[] spl) {
        double liters = Double.valueOf(spl[2]);

        if (spl[1].equals("Car")) {
            car.refuel(liters);
        } else if (spl[1].equals("Truck")) {
            truck.refuel(liters);
        }
    }

    private static void drive(String[] spl) {
        double dist = Double.valueOf(spl[2]);

        if (spl[1].equals("Car")) {
            car.drive(dist);
        } else if (spl[1].equals("Truck")) {
            truck.drive(dist);
        }
    }
}
