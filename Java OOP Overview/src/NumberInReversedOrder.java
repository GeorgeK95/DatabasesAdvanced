import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */

public class NumberInReversedOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String number = in.nextLine();
        String numberReversed = reverse(number);
        System.out.println(numberReversed);
    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
