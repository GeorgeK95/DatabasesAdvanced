package BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by George-Lenovo on 7/5/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        List<Guest> elements = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        while (!line.equals("End")) {
            String[] params = line.split(" ");

            if (params.length == 3) {
                Guest robotPet = new BorderControl(params[0], params[1], params[2]);
                elements.add(robotPet);
            } else if (params.length == 5) {
                Guest citizen = new BorderControl(params[0], params[1], Integer.parseInt(params[2]), params[3], params[4]);
                elements.add(citizen);
            } else
                System.out.println("Wrong input.");

            line = reader.readLine();
        }

        String compYear = reader.readLine();

        for (Guest element : elements) {
            if (element.compareYear(compYear)) {
                System.out.println(element.getBirthdate());
            }
        }
    }
}
