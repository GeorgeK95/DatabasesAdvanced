import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class ReverseCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = "";

        for (int i = 0; i < 3; i++) {
            String input = in.nextLine();
            str += input;
        }

        System.out.println(new StringBuilder(str).reverse().toString());
    }
}
