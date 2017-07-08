import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class StudentsByGroup {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        while (true) {
            String line = in.nextLine();

            if (line.equals("END")) {
                break;
            }

            String[] spl = line.split("\\s+");
            Person person = new Person(spl[0], spl[1], Integer.parseInt(spl[2]));
            people.add(person);
        }

        people.stream().filter(x -> x.getG() == 2).sorted(Comparator.comparing(Person::getF))
                .forEach(System.out::println);
    }
}

class Person {
    private String f;
    private String s;
    private int g;

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

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public Person(String f, String s, int g) {

        this.f = f;
        this.s = s;
        this.g = g;
    }
}
