import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class FilterStudentsByPhone {
    private static String first_phone = "+3592";
    private static String second_phone = "02";

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

        map.entrySet().stream().filter(x -> x.getValue().startsWith(first_phone) || x.getValue().startsWith(second_phone)).forEach(x -> System.out.println(x.getKey()));
    }
}
