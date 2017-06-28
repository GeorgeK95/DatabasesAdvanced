import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class CompareCharArrays {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        char[] chArr1 = in.nextLine().toCharArray();
        char[] chArr2 = in.nextLine().toCharArray();

        boolean isPrinted = false;

        for (int i = 0; i < Math.min(chArr1.length, chArr2.length); i++) {
            if (chArr1[i] != ' ' && chArr2[i] != ' ') {
                if (chArr1[i] < chArr2[i]) {
                    Print(chArr1, chArr2);
                    isPrinted = true;
                    break;
                } else if (chArr1[i] > chArr2[i]) {
                    Print(chArr2, chArr1);
                    isPrinted = true;
                    break;
                }
            }

        }

        if (!isPrinted) {
            if (chArr1.length < chArr2.length) {
                Print(chArr1, chArr2);
            } else {
                Print(chArr2, chArr1);
            }
        }
    }

    private static void Print(char[] first, char[] second) {
        for (char a : first) {
            if (a != ' ')
                System.out.print(a);
        }
        System.out.println();
        for (char a : second) {
            if (a != ' ')
                System.out.print(a);
        }
    }
}
