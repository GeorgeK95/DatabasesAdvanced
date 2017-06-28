import java.util.*;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class PhonebookUpgrade {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        TreeMap<String, String> phoneBook = new TreeMap<String, String>();

        while (!command.equals("END")) {
            String[] splittedCommand = command.split(" ");

            if (splittedCommand[0].equals("A")) {
                AddContact(phoneBook, splittedCommand);
            } else if (splittedCommand[0].equals("S")) {
                SearchContact(phoneBook, splittedCommand);
            } else if (splittedCommand[0].equals("ListAll")) {
                PrintListedPhoneBook(phoneBook);
            } else {
                System.out.println("Invalid command");
            }

            command = in.nextLine();
        }
    }

    private static void PrintListedPhoneBook(TreeMap<String, String> phoneBook) {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    private static void SearchContact(TreeMap<String, String> phoneBook, String[] splittedCommand) {
        if (phoneBook.containsKey(splittedCommand[1])) {
            System.out.println(splittedCommand[1] + " -> " + phoneBook.get(splittedCommand[1]));
        } else {
            System.out.println("Contact " + splittedCommand[1] + " does not exist.");
        }
    }

    private static void AddContact(TreeMap<String, String> phoneBook, String[] splittedCommand) {
        if (phoneBook.containsKey(splittedCommand[1])) {
            phoneBook.put(splittedCommand[1], splittedCommand[2]);
        } else {
            phoneBook.put(splittedCommand[1], splittedCommand[2]);
        }
    }

}
