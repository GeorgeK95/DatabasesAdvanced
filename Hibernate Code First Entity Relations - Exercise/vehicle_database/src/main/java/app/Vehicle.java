package app;

import entities.motor.Car;
import entities.motor.Plane;
import entities.motor.ship.CargoShip;
import entities.motor.ship.CruiseShip;
import entities.motor.train.Carriage;
import entities.motor.train.CarriageType;
import entities.motor.train.Locomotive;
import entities.motor.train.Train;
import entities.nonmotor.Bike;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
public class Vehicle {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("vehicledb");
        EntityManager em = emf.createEntityManager();
        addDataToDb(em);
        emf.close();
    }

    private static void addDataToDb(EntityManager em) {
        em.getTransaction().begin();
        Car car = new Car();
        car.setManufacturer("VW");
        car.setMaxSpeed(200);
        car.setModel("Golf");
        car.setPrice(new BigDecimal(5000));
        car.setNumberOfDoors(5);
        car.setInformation("Golfu bateee");
        car.setEngineType("Petrol");
        car.setNumberOfEngines(4);
        car.setTankCapacity(55);

        Bike bike = new Bike();
        bike.setPrice(new BigDecimal(200));
        bike.setModel("bmx");
        bike.setMaxSpeed(55);
        bike.setManufacturer("BMX");
        bike.setColor("black");
        bike.setShiftsCount(1);

        CargoShip cargoShip = new CargoShip();
        cargoShip.setTankCapacity(1000);
        cargoShip.setManufacturer("Ship OOD");
        cargoShip.setNumberOfEngines(10);
        cargoShip.setEngineType("Fuel oil");
        cargoShip.setMaxSpeed(50);
        cargoShip.setMaxLoadKg(new Long(20000));
        cargoShip.setCaptainName("jack sparou");
        cargoShip.setCrewSize(12);
        cargoShip.setModel("shipModel#1");
        cargoShip.setPrice(new BigDecimal(87999));

        CruiseShip cruiseShip = new CruiseShip();
        cruiseShip.setTankCapacity(1000);
        cruiseShip.setManufacturer("Ship OOD");
        cruiseShip.setNumberOfEngines(10);
        cruiseShip.setEngineType("Fuel oil");
        cruiseShip.setMaxSpeed(50);
        cruiseShip.setPassengersCapacitiy(1300);
        cruiseShip.setCaptainName("jack sparou");
        cruiseShip.setCrewSize(12);
        cruiseShip.setModel("shipModel#1");
        cruiseShip.setPrice(new BigDecimal(87999));

        Plane plane = new Plane();
        plane.setMaxSpeed(1100);

        Locomotive l = new Locomotive();
        l.setModel("locomotiveModel");
        l.setPower(1222);
        em.persist(l);

        Train t = new Train();
        t.setManufacturer("Train Manuf");
        t.setMaxSpeed(220);
        t.setModel("RocketTrain");
        t.setPrice(new BigDecimal(500000));
        t.setEngineType("Diesel");
        t.setNumberOfEngines(2);
        t.setTankCapacity(480);
        t.setLocomotive(l);
        t.setNumberOfCarriages(12);

        Carriage carriage = new Carriage();
        carriage.setCarriageType(CarriageType.Restaraunt);
        carriage.setTrain(t);
        carriage.setCarriageTypeCount(120);
        em.persist(carriage);


        em.persist(car);
        em.persist(bike);
        em.persist(cruiseShip);
        em.persist(cargoShip);
        em.persist(plane);
        em.persist(t);
        em.getTransaction().commit();
        em.close();


    }
}
