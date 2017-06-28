import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        String hex = Integer.toHexString(Integer.parseInt(input));
        String bin = Integer.toBinaryString(Integer.parseInt(input));

        System.out.println(hex.toUpperCase());
        System.out.println(bin);
    }
}
