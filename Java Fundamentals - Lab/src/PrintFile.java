import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class PrintFile {
    public static void main(String[] args) {
        boolean isPrinted = false;
        Scanner read = new Scanner(System.in);
        char c = 'y';

        try {
            do {
                System.out.println("Enter path: ");
                String path = read.nextLine();
                try {
                    print(path);
                    isPrinted = true;
                } catch (FileNotFoundException e) {
                    System.out.println("File was not found.");
                    System.out.println("Again ? y/n");
                    c = read.nextLine().toLowerCase().trim().charAt(0);
                }
            } while (!isPrinted && c == 'y');
        } finally {
            read.close();
        }

        if (isPrinted) {
            System.out.println("File printed successfully !");
        }
        System.out.println("Good bye !");
    }

    private static void print(String path) throws FileNotFoundException {
        File f = new File(path);
        Scanner in = new Scanner(f);

        try {
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } finally {
            in.close();
        }
    }
}
