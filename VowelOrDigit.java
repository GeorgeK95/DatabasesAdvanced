import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class VowelOrDigit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char ch = in.next().charAt(0);

        if (isCharVowel(ch)) {
            System.out.println("vowel");
        } else if (isCharDigit(ch)) {
            System.out.println("digit");
        } else
            System.out.println("other");
    }

    private static boolean isCharDigit(char ch) {
        if ((int) ch >= 48 && (int) ch <= 57)
            return true;
        return false;
    }

    private static boolean isCharVowel(char ch) {
        if ((int) ch == 97 || (int) ch == 65 || (int) ch == 101 || (int) ch == 105 || (int) ch == 73 || (int) ch == 111 || (int) ch == 79 || (int) ch == 117 || (int) ch == 85)
            return true;
        return false;
    }
}

