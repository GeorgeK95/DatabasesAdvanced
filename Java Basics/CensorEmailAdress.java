import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class CensorEmailAdress {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String email = in.nextLine();
        String domaine = getDomaine(email);
        String text = in.nextLine();

        String userName = getUserName(email);
        String substituent = generateAsterix(userName.length());

        String newEmail = substituent.concat(domaine);
        text = text.replaceAll(email, newEmail);
        System.out.println(text);
    }

    private static String getDomaine(String email) {
        int index = email.indexOf('@');
        StringBuilder sb = new StringBuilder();

        for (int i = index; i < email.length(); i++) {
            sb.append(email.charAt(i));
        }

        return  sb.toString();
    }

    private static String getUserName(String email) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < email.length(); i++) {
            char currChar = email.charAt(i);

            if (currChar == '@') {
                break;
            } else {
                sb.append(currChar);
            }
        }

        return  sb.toString();
    }

    private static String generateAsterix(int userNameLength) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < userNameLength; i++) {
            sb.append("*");
        }

        return sb.toString();
    }

}
