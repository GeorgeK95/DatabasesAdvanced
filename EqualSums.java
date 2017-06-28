import java.util.Scanner;

/**
 * Created by George-Lenovo on 4/5/2017.
 */
public class EqualSums {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int[] numbers = getNumbers(input);
        GetIndexOfEqualSumsElement(numbers);
    }

    private static int[] getNumbers(String input) {
        String[] items = input.split(" ");

        int[] numbers =  new int[items.length];

        for (int i = 0; i < items.length; i++) {
            numbers[i] = Integer.parseInt(items[i]);
        }

        return numbers;
    }

    private static void GetIndexOfEqualSumsElement(int[] array)
    {
        boolean isPrinted = false;

        for (int i = 0; i < array.length; i++)
        {
            int sumLeft = GetSumForCurrentElement(array, i, "left");
            int sumRight = GetSumForCurrentElement(array, i, "right");

            if (sumLeft == sumRight)
            {
                System.out.println(i);
                isPrinted = true;
                break;
            }
        }

        if (!isPrinted)
        {
            System.out.println("no");
        }
    }

    private static int GetSumForCurrentElement(int[] array, int index, String v)
    {
        int sum = 0;

        switch (v)
        {
            case "left":
                for (int i = 0; i < index; i++)
                {
                    sum += array[i];
                }
                break;

            case "right":
                for (int i = index + 1; i < array.length; i++)
                {
                    sum += array[i];
                }
                break;
        }

        return sum;
    }
}
