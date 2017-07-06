package BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

            if (params.length == 2) {
                Guest robot = new BorderControl(params[0], params[1]);
                elements.add(robot);
            } else if (params.length == 3) {
                Guest citizen = new BorderControl(params[0], Integer.parseInt(params[1]), params[2]);
                elements.add(citizen);
            } else
                System.out.println("Wrong input.");
            line = reader.readLine();
        }

        String compareId = reader.readLine();

        for (Guest element : elements) {
            if (element.isFake(compareId)) {
                System.out.println(element.getId());
            }
        }
    }
}
