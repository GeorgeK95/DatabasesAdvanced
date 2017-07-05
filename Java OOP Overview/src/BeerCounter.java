/**
 * Created by George-Lenovo on 6/30/2017.
 */
public class BeerCounter {
    public static int getBeerInStock() {
        return beerInStock;
    }

    public static int getBeersDrankCount() {
        return beersDrankCount;
    }

    private static int beerInStock;
    private static int beersDrankCount;

    static {
        beerInStock = 0;
        beersDrankCount = 0;
    }

    public static void buyBeer(int bottlesCount) {
        BeerCounter.beerInStock += bottlesCount;
    }

    public static void drinkBeer(int bottlesCount) {
        BeerCounter.beersDrankCount += bottlesCount;
        BeerCounter.beerInStock -= bottlesCount;
    }

}
