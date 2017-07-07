import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.DoubleStream;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class MinEvenNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        OptionalDouble min = Arrays.stream(in.nextLine()
                .split("\\s+"))
                .filter(x -> !x.isEmpty())
                .mapToDouble(Double::valueOf)
                .filter(x -> x % 2 == 0)
                .sorted()
                .findFirst();

        print(min);
    }

    private static void print(OptionalDouble min) {
        if (min.isPresent()) {
            DecimalFormat df = new DecimalFormat("#.00");
            String angleFormated = df.format(min.getAsDouble());
            System.out.println(angleFormated);
        } else {
            System.out.println("No match");
        }
    }
}
