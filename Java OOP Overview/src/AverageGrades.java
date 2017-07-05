import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by George-Lenovo on 4/6/2017.
 */

public class AverageGrades {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<Student> students = new ArrayList<Student>();

        for (int i = 0; i < n; i++) {
            String[] studentInfo = in.nextLine().split(" ");
            String name = studentInfo[0];
            List<Double> grades = new ArrayList<Double>();

            MakeStudents(grades, studentInfo, name, students);
        }

        PrintStudents(students);
    }

    private static void PrintStudents(List<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                String x1 = ((Student) o1).getName();
                String x2 = ((Student) o2).getName();
                int sComp = x1.compareTo(x2);

                if (sComp != 0) {
                    return sComp;
                } else {
                    Double y1 = ((Student) o2).getGrade();
                    Double y2 = ((Student) o1).getGrade();
                    return y1.compareTo(y2);
                }
            }
        });

        for (Student stud : students) {
            System.out.printf("%s -> %.2f%n", stud.getName(), stud.getGrade());
        }


    }

    private static void MakeStudents(List<Double> grades, String[] studentInfo, String name, List<Student> students) {
        for (int j = 1; j < studentInfo.length; j++) {
            grades.add(Double.parseDouble(studentInfo[j]));
        }

        double avgGrade = calculateAverage(grades);//grades.stream().mapToDouble(val -> val).average().getAsDouble();

        if (avgGrade >= 5) {
            Student student = new Student(avgGrade, name);
            students.add(student);
        }
    }

    private static double calculateAverage(List<Double> marks) {
        if (marks == null || marks.isEmpty()) {
            return 0;
        }

        double sum = 0;
        for (Double mark : marks) {
            sum += mark;
        }

        return sum / marks.size();
    }
}
