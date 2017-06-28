import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class FitStringIn20Chars {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        if (input.length() < 20) {
            input = addStars(input, input.length());
        } else {
            input = cut(input);
        }

        System.out.println(input);
    }

    private static String cut(String input) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 20; i++) {
            sb.append(input.charAt(i));
        }

        return sb.toString();
    }

    private static String addStars(String input, int length) {
        for (int i = 0; i < 20 - length; i++) {
            input = input.concat("*");
        }

        return input;
    }
}
