import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class FindAndSumIntegers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = Arrays.stream(in.nextLine().split("\\s+")).filter(x -> !x.isEmpty()).filter(FindAndSumIntegers::isInteger).mapToInt(Integer::valueOf).toArray();

        print(numbers);


    }

    private static void print(int[] numbers) {
        if (numbers.length != 0) {
            System.out.println(Arrays.stream(numbers).sum());
        } else {
            System.out.println("No match");
        }
    }

    public static boolean isInteger(String s) {
        return isInteger(s, 10);
    }

    public static boolean isInteger(String s, int radix) {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0 && s.charAt(i) == '-') {
                if (s.length() == 1) return false;
                else continue;
            }
            if (Character.digit(s.charAt(i), radix) < 0) return false;
        }
        return true;
    }
}
