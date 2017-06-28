import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class BooleanVariable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        boolean result = Boolean.parseBoolean(input);

        if (result == true) {
            System.out.println("Yes");
        }
        else
            System.out.println("No");
    }
}
