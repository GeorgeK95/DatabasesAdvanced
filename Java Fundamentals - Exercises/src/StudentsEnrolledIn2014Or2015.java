import java.util.*;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class StudentsEnrolledIn2014Or2015 {
    private static String endYear_14 = "14";
    private static String endYear_15 = "15";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, List<Integer>> map = new LinkedHashMap<>();

        while (true) {
            String line = in.nextLine();

            if (line.equals("END")) {
                break;
            }

            String[] spl = line.split("\\s+");
            List<Integer> temp = new ArrayList<>();

            for (int i = 1; i < spl.length; i++) {
                int s = Integer.parseInt(spl[i]);
                temp.add(s);
            }

            map.put(spl[0], temp);
        }

        map.entrySet().stream().filter(x -> x.getKey().endsWith(endYear_14) || x.getKey().endsWith(endYear_15))
                .forEach(x -> print(x));
    }

    private static void print(Map.Entry<String, List<Integer>> x) {
        for (int o : x.getValue()) {
            System.out.print(o + " ");
        }
        System.out.println();
    }
}
