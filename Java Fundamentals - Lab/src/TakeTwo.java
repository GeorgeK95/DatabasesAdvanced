import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class TakeTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Arrays
                .stream(in.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::valueOf)
                .distinct()
                .filter(x -> x >= 10 && x <= 20)
                .limit(2).forEach(x -> System.out.print(x + " "));
    }
}
