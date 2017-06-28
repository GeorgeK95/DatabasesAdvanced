import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class VariableInHexFormat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int result = 0;
        int power = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            char currentChar = input.charAt(i);
            int charValue = getCharValue(currentChar);

            result += charValue * Math.pow(16, power);
            power++;
        }

        System.out.println(result);
    }

    private static int getCharValue(char c) {
        int newnum = 0;

        if (c == 'A') {
            newnum = 10;
        }
        if (c == 'B') {
            newnum = 11;
        }
        if (c == 'C') {
            newnum = 12;

        }
        if (c == 'D') {
            newnum = 13;

        }
        if (c == 'E') {
            newnum = 14;

        }
        if (c == 'F') {
            newnum = 15;

        } else {
            newnum = Character.getNumericValue(c);
        }

        return newnum;
    }
}
