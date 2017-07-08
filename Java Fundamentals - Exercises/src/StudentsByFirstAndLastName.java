import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentsByFirstAndLastName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<AnotherPerson> people = new LinkedList<>();

        while (true) {
            String line = in.nextLine();

            if (line.equals("END")) {
                break;
            }

            String[] spl = line.split("\\s+");
            AnotherPerson person = new AnotherPerson(spl[0], spl[1]);
            people.add(person);
        }

        people.stream().filter(x -> x.getF().compareTo(x.getS()) < 0).forEach(System.out::println);
    }
}

class AnotherPerson {
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

    public AnotherPerson(String f, String s) {
        this.f = f;
        this.s = s;
    }
}
