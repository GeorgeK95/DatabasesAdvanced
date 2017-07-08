import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class ExcellentStudents {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Map<String, List<Integer>> map = new LinkedHashMap<>();

        while (!line.equals("END")) {
            String[] spl = line.split("\\s+");
            String name = spl[0] + " " + spl[1];
            List<Integer> temp = new ArrayList<>();

            for (int i = 2; i < spl.length; i++) {
                int s = Integer.parseInt(spl[i]);
                temp.add(s);
            }

            map.put(name, temp);
            line = in.nextLine();
        }

        map.entrySet().stream().filter(x -> x.getValue().contains(6)).forEach(x -> System.out.println(x.getKey()));
    }
}
