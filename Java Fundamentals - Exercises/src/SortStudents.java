import java.util.*;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class SortStudents {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        List<Student> pp = new ArrayList<>();

        while (!line.equals("END")) {
            String[] spl = line.split("\\s+");
            pp.add(new Student(spl[0], spl[1]));
            line = in.nextLine();
        }

        pp.stream().sorted(Comparator.comparing(Student::getS)
                .thenComparing(Comparator.comparing(Student::getF).reversed()))
                .forEach(System.out::println);
    }
}

class Student {
    private String f;
    private String s;

    @Override
    public String toString() {
        return f + " " + s;
    }

    public String getF() {
        return f;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public Student(String f, String s) {

        this.f = f;
        this.s = s;
    }
}