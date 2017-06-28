import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class MaxSequenceOfIncreasingElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int[] numbers = getNumbers(input);
        List<Integer> values = GetLongestSequenceOfIncreasingElements(numbers);
        PrintResult(values);
    }

    private static void PrintResult(List<Integer> values) {
        for (int number : values
                ) {
            System.out.printf("%d", number);
            System.out.print(" ");
        }
    }

    private static int[] getNumbers(String input) {
        String[] items = input.split(" ");

        int[] numbers = new int[items.length];

        for (int i = 0; i < items.length; i++) {
            numbers[i] = Integer.parseInt(items[i]);
        }

        return numbers;
    }

    private static List<Integer> GetLongestSequenceOfIncreasingElements(int[] array) {
        List<Integer> values = new ArrayList<Integer>();
        int bestLength = 0;

        for (int i = 0; i < array.length - 1; i++) {
            int currLength = 0;
            List<Integer> tempList = new ArrayList<Integer>();
            tempList.add(array[i]);

            for (int j = i; j < array.length - 1; j++) {
                if (array[j] < array[j + 1]) {
                    currLength++;
                    tempList.add(array[j + 1]);

                    if (currLength > bestLength) {
                        bestLength = currLength;
                        values = tempList;
                    }
                } else {
                    break;
                }
            }
        }

        return values;
    }
}
