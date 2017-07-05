/**
 * Created by George-Lenovo on 7/5/2017.
 */
public class Main {
    public static void main(String[] args) {
        Sellable seat = new Seat("Leon", "gray", 110, "Spain", 111111.1);
        Rentable audi = new Audi("Leon", "gray", 110, "Spain", 111, 123.1);

        printCarInfo(seat);
        printCarInfo(audi);
    }

    private static void printCarInfo(Car car) {
        System.out.println(String.format(
                "%s is %s color and have %s horse power",
                car.getModel(),
                car.getColor(),
                car.getHorsePower()));
        System.out.println(car.toString());
    }


}
