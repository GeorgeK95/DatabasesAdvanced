import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class UpperStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split("\\s+");
        Arrays.stream(arr).map(String::toUpperCase).forEach(z -> System.out.print(z + " "));
    }
}
