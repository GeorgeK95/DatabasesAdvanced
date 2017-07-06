package Mankind;

/**
 * Created by George-Lenovo on 7/6/2017.
 */
public class Human {
    private String firstName;
    private String lastName;

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        char f = firstName.charAt(0);

        if (f >= 65 && f <= 90) {
            if (firstName.length() < 4) {
                throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
            } else {
                this.firstName = firstName;
            }
        } else {
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
    }

    public String getLastName() {
        return this.lastName;
    }

    protected  void setLastName(String lastName) {
        char f = lastName.charAt(0);
        if (f >= 65 && f <= 90) {
            if (lastName.length() < 3) {
                throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
            } else {
                this.lastName = lastName;
            }
        } else {
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
    }
}
