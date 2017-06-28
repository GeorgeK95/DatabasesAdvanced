import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class ReverseString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(Reverse(input));
    }
    public static String Reverse(String s)
    {
        char[] charArray = s.toCharArray();
        String reverse = new StringBuilder(new String(charArray)).reverse().toString();
        return reverse;
    }

}


