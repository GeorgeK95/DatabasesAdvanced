import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.DoubleStream;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class AverageOfDoubles {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        OptionalDouble avg = Arrays.stream(in.nextLine().split("\\s+")).filter(x -> !x.isEmpty()).mapToDouble(Double::valueOf).average();

        print(avg);

    }

    private static void print(OptionalDouble avg) {
        if (avg.isPresent()) {
            DecimalFormat df = new DecimalFormat("#.00");
            String angleFormated = df.format(avg.getAsDouble());
            System.out.println(angleFormated);
        } else {
            System.out.println("No match");
        }
    }
}
