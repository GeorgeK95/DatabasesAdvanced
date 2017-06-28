import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class MostFrequentNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        int[] numbers = getNumbers(input);
        int mostCommonNumber = GetMostCommonElement(numbers);
        System.out.println(mostCommonNumber);
    }

    private static int[] getNumbers(String input) {
        String[] items = input.split(" ");

        int[] numbers = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            numbers[i] = Integer.parseInt(items[i]);
        }

        return numbers;
    }

    private static int GetMostCommonElement(int[] array) {
        int number = 0;
        int bestCount = 0;

        for (int i = 0; i < array.length; i++) {
            int currCount = 0;

            for (int j = 0; j < array.length; j++) {
                if (array[i] == array[j]) {
                    currCount++;

                    if (currCount > bestCount) {
                        bestCount = currCount;
                        number = array[i];
                    }
                }
            }
        }

        return number;
    }
}
