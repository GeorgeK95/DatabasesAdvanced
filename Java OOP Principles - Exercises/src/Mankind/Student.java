package Mankind;

/**
 * Created by George-Lenovo on 7/6/2017.
 */
public class Student extends Human {
    private String number;

    public Student(String firstName, String lastName, String number) {
        super(firstName, lastName);
        this.setNumber(number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        if (number.length() < 5 || number.length() > 10) {
            throw new IllegalArgumentException("Invalid faculty number!");
        }

        this.number = number;
    }


}
