import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 7/8/2017.
 */
public class GroupByGroup {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Person_10> people = new ArrayList<>();

        while (true) {
            String line = in.nextLine();
            if (line.equals("END")) {
                break;
            }

            String[] spl = line.split("\\s+");

            String name = spl[0] + " " + spl[1];
            int group = Integer.parseInt(spl[2]);
            Person_10 person_10 = new Person_10(name, group);

            people.add(person_10);
        }

        people.stream().collect(Collectors.groupingBy(Person_10::getGroup)).entrySet()
                .forEach(x -> System.out.println(x.getKey() + " - " + printList(x.getValue())));
    }

    private static String printList(List<Person_10> y) {
        return join(y, ", ");
    }

    private static String join(Collection<?> s, String delimiter) {
        StringBuilder builder = new StringBuilder();
        Iterator<?> iter = s.iterator();
        while (iter.hasNext()) {
            builder.append(iter.next());
            if (!iter.hasNext()) {
                break;
            }
            builder.append(delimiter);
        }
        return builder.toString();
    }
}

class Person_10 {
    private String name;
    private int group;

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public Person_10(String name, int group) {
        this.name = name;
        this.group = group;
    }
}