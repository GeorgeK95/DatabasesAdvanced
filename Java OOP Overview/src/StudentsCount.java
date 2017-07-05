import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/30/2017.
 */
public class StudentsCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        while (!input.equals("End")) {
            Student stud = new Student(input);
            input = in.nextLine();
        }

        System.out.println(Student.getCounter());
    }
}
