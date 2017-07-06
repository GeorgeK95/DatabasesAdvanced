package BirthdayCelebrations;

/**
 * Created by George-Lenovo on 7/5/2017.
 */
public class Student implements Human {
    private String firstName;
    private String lastName;
    private String number;
    private boolean success = true;

    public boolean isSuccess() {
        return success;
    }

    public Student(String firstName, String lastName, String number) {
//        super(firstName, lastName);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setNumber(number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        int l = number.length();

        if (l >= 5 && l <= 10) {
            this.number = number;
        } else {
            System.out.println("Invalid faculty number!");
            success = false;
        }

    }

    public void setFirstName(String firstName) {
        char fletter = firstName.charAt(0);

        if (fletter >= 65 && fletter <= 90) {
            if (firstName.length() > 4) {
                this.firstName = firstName;
            } else {
                System.out.println("Expected length at least 4 symbols!Argument: firstName");
                success = false;
            }
        } else {
            System.out.println("Expected upper case letter!Argument: firstName");
            success = false;
        }

    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    @Override
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        char fletter = firstName.charAt(0);

        if (fletter >= 65 && fletter <= 90) {
            if (firstName.length() > 3) {
                this.lastName = lastName;
            } else {
                System.out.println("Expected length at least 3 symbols!Argument: lastName");
                success = false;
            }
        } else {
            System.out.println("Expected upper case letter!Argument: lastName");
            success = false;
        }


    }

    @Override
    public String toString() {
        return "First Name: " + firstName + '\n' +
                "Last Name: " + lastName + '\n' +
                "Faculty number: " + number + '\n';
    }
}
