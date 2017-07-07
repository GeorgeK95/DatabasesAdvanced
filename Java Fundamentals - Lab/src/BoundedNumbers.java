import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class BoundedNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] bounds = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int[] numbers = Arrays.stream(in.nextLine().split("\\s+")).filter(x -> !x.isEmpty()).mapToInt(Integer::valueOf).toArray();

        int[] b = Arrays.stream(numbers).filter(x -> x >= Arrays.stream(bounds).min().getAsInt() && x <= Arrays.stream(bounds).max().getAsInt()).toArray();

        print(b);
    }

    private static void print(int[] b) {
        if (b.length != 0) {
            Arrays.stream(b).forEach(x -> System.out.print(x + " "));
        }
    }
}
