import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class StudentsByAge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        String line = in.nextLine();

        while (!line.equals("END")) {
            String[] spl = line.split("\\s+");
            String name = spl[0] + " " + spl[1];
            int age = Integer.parseInt(spl[2]);

            map.put(name, age);
            line = in.nextLine();
        }

        map.entrySet().stream().filter(x -> x.getValue() >= 18 && x.getValue() <= 24).forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
    }
}
