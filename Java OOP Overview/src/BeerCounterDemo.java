import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/30/2017.
 */
public class BeerCounterDemo{
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = in.readLine();

            try {
                if (input.equals("End")) {
                    break;
                }

                String[] splitted = input.split(" ");
                BeerCounter.buyBeer(Integer.parseInt(splitted[0]));
                BeerCounter.drinkBeer(Integer.parseInt(splitted[1]));

            } catch (Exception e) {
                break;
            }
        }

        System.out.println(BeerCounter.getBeerInStock() + " " + BeerCounter.getBeersDrankCount());
    }
}
