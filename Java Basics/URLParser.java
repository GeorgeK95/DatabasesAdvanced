import com.sun.javafx.image.BytePixelSetter;

import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class URLParser {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] splittedInput = input.split("://");

        if (splittedInput.length == 1) {
            Print(splittedInput[0]);
        } else {
            String protocol = splittedInput[0];
            String[] splittedInput1 = splittedInput[1].split("/");
            String domaine = splittedInput1[0];

            if (splittedInput1.length == 1) {
                Print(protocol, domaine);
            } else {
                StringBuilder resource = new StringBuilder();

                for (int i = 1; i < splittedInput1.length; i++) {
                    if (i == splittedInput1.length - 1) {
                        resource.append(splittedInput1[i]);
                    } else {
                        resource.append(splittedInput1[i]);
                        resource.append('/');
                    }

                }
                Print(protocol, domaine, resource.toString());
            }
        }

    }

    private static void Print(String protocol, String domaine, String s) {
        System.out.printf("[protocol] = \"%s\"", protocol);
        System.out.println();
        System.out.printf("[server] = \"%s\"", domaine);
        System.out.println();
        System.out.printf("[resource] = \"%s\"", s);
    }

    private static void Print(String protocol, String domaine) {
        System.out.printf("[protocol] = \"%s\"", protocol);
        System.out.println();
        System.out.printf("[server] = \"%s\"", domaine);
        System.out.println();
        System.out.print("[resource] = \"\"");
    }

    private static void Print(String s) {
        System.out.print("[protocol] = \"\"");
        System.out.println();
        System.out.printf("[server] = \"%s\"", s);
        System.out.println();
        System.out.print("[resource] = \"\"");
    }
}
