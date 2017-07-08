import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class FilterStudentsByEmailDomain {
    private static String domaine = "@gmail.com";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, String> map = new LinkedHashMap<>();
        String line = in.nextLine();

        while (!line.equals("END")) {
            String[] spl = line.split("\\s+");
            String key = spl[0] + " " + spl[1];
            String val = spl[2];

            map.put(key, val);
            line = in.nextLine();
        }

        map.entrySet().stream().filter(x -> x.getValue().endsWith(domaine)).forEach(x -> System.out.println(x.getKey()));
    }
}
