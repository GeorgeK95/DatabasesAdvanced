import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class IndexOfLetters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        char[] letters = input.toCharArray();
        Print(letters);
    }

    private static void Print(char[] letters) {
        for (int i = 0; i < letters.length; i++)
        {
            int value = letters[i] - 97;
            System.out.println(letters[i] + " -> " + value);
        }
    }
}
