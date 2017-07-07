import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class FirstName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split("\\s+");
        char letter = in.nextLine().toLowerCase().charAt(0);

        Optional<String> matches = Arrays.stream(arr).filter(x -> x.toLowerCase().charAt(0) == letter).sorted().findFirst();
        if (matches.isPresent()) {
            System.out.println(matches.get());
        } else {
            System.out.println("No match");
        }
    }

}
