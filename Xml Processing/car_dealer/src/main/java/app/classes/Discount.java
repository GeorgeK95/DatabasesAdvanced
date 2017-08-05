package app.classes;

import java.util.Random;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
public class Discount {
    public static int getRandomDiscount() {
        int[] discounts = new int[]{
                0, 5, 10, 15, 20, 30, 40, 50
        };
        Random rand = new Random();
        int i = rand.nextInt(8);
        return discounts[i];
    }
}
