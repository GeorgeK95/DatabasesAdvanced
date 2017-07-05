import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class LastDigitName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = Long.parseLong(in.nextLine());
        String name = getLastDigitName(num);
        System.out.println(name);
    }

    private static String getLastDigitName(long num) {
        String numStr = Long.toString(num);
        char letter = numStr.charAt(numStr.length() - 1);

        String returnValue = null;

        switch (letter) {
            case '0':
                returnValue = "zero";
                break;
            case '1':
                returnValue = "one";
                break;
            case '2':
                returnValue = "two";
                break;
            case '3':
                returnValue = "three";
                break;
            case '4':
                returnValue = "four";
                break;
            case '5':
                returnValue = "five";
                break;
            case '6':
                returnValue = "six";
                break;
            case '7':
                returnValue = "seven";
                break;
            case '8':
                returnValue = "eight";
                break;
            default:
                returnValue = "nine";
                break;
        }

        return returnValue;
    }
}
