import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class Phonebook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        HashMap<String, String> phoneBook = new HashMap<String, String>();

        while (!command.equals("END")) {
            String[] splittedCommand = command.split(" ");

            if (splittedCommand[0].equals("A")) {
                AddContact(phoneBook, splittedCommand);
            } else if (splittedCommand[0].equals("S")) {
                SearchContact(phoneBook, splittedCommand);
            } else {
                System.out.println("Invalid command");
            }

            command = in.nextLine();
        }
    }

    private static void SearchContact(HashMap<String, String> phoneBook, String[] splittedCommand) {
        if (phoneBook.containsKey(splittedCommand[1])) {
            System.out.println(splittedCommand[1] + " -> " + phoneBook.get(splittedCommand[1]));
        } else {
            System.out.println("Contact " + splittedCommand[1] + " does not exist.");
        }
    }

    private static void AddContact(HashMap<String, String> phoneBook, String[] splittedCommand) {
        if (phoneBook.containsKey(splittedCommand[1])) {
            phoneBook.put(splittedCommand[1], splittedCommand[2]);
        } else {
            phoneBook.put(splittedCommand[1], splittedCommand[2]);
        }
    }
}
