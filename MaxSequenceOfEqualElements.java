import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int[] numbers = getNumbers(input);
        FindMaxSequenceAndPrintIt(numbers);
    }

    private static int[] getNumbers(String input) {
        String[] items = input.split(" ");

        int[] numbers =  new int[items.length];

        for (int i = 0; i < items.length; i++) {
            numbers[i] = Integer.parseInt(items[i]);
        }

        return numbers;
    }

    private static void FindMaxSequenceAndPrintIt(int[] numbers)
    {
        int element = numbers[0];
        int bestCount = 0;
        int currCount = 0;

        for (int i = 0; i < numbers.length - 1; i++)
        {
            if (numbers[i] == numbers[i + 1])
            {
                currCount++;
                if (currCount > bestCount)
                {
                    bestCount = currCount;
                    element = numbers[i];
                }
            }
            else
            {
                currCount = 0;
            }
        }

        PrintResult(bestCount, element);
    }

    private static void PrintResult(int bestCount, int element)
    {
        for (int i = 0; i <= bestCount; i++)
        {
            if (i == bestCount)
            {
                System.out.print(element);
            }
            else
            {
                System.out.print(element + " ");
            }
        }
    }
}
