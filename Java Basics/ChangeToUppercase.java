import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/28/2017.
 */
public class ChangeToUppercase {
    private static final String openTag ="<upcase>";
    private static final String closeTag ="</upcase>";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();

        while(text.contains(openTag) && text.contains(closeTag)) {
            int startIndex = text.indexOf(openTag);
            int endIndex = text.indexOf(closeTag, startIndex);
            String subTextWithTags = text.substring(startIndex, endIndex + closeTag.length());
            String clearSubText = subTextWithTags.replace(openTag, "");
            clearSubText = clearSubText.replace(closeTag, "");
            String subTextUppercased = clearSubText.toUpperCase();
            text = text.replace(subTextWithTags, subTextUppercased);
        }

        System.out.println(text);
    }
}
