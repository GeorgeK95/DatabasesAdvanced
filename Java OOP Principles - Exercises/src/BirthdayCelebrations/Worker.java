package BirthdayCelebrations;

import java.text.DecimalFormat;

/**
 * Created by George-Lenovo on 7/5/2017.
 */
public class Worker implements Human {
    private String firstName;
    private String lastName;
    private double weekSalary;
    private int workHoursPerDay;
    private boolean success = true;

    public Worker(String firstName, String lastName, double weekSalary, int workHoursPerDay) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setWeekSalary(weekSalary);
        this.setWorkHoursPerDay(workHoursPerDay);
    }

    public double calculateMoney() {
        DecimalFormat df = new DecimalFormat("#.##");
        double res = (this.weekSalary / 7) / this.workHoursPerDay;
        return Double.valueOf(df.format(res));
    }

    public double getWeekSalary() {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(this.weekSalary));

    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary > 10) {
            this.weekSalary = weekSalary;
        } else {
            System.out.println("Expected value mismatch!Argument: weekSalary");
            success = false;
        }
    }

    public double getWorkHoursPerDay() {
        DecimalFormat df = new DecimalFormat("#.##");
        return Double.valueOf(df.format(this.workHoursPerDay));
    }

    public void setWorkHoursPerDay(int workHoursPerDay) {
        if (workHoursPerDay >= 1 && workHoursPerDay <= 12) {
            this.workHoursPerDay = workHoursPerDay;
        } else {
            System.out.println("Expected value mismatch!Argument: workHoursPerDay");
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
            }
        } else {
            System.out.println("Expected upper case letter!Argument: firstName");
        }

    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    public void setLastName(String lastName) {
        char fletter = firstName.charAt(0);

        if (fletter >= 65 && fletter <= 90) {
            if (firstName.length() > 3) {
                this.lastName = lastName;
            } else {
                System.out.println("Expected length more than 3 symbols!Argument: lastName");
            }
        } else {
            System.out.println("Expected upper case letter!Argument: lastName");
        }


    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "First Name: " + firstName + '\n' +
                "Last Name: " + lastName + '\n' +
                "Week Salary: " + getWeekSalary() + '\n' +
                "Hours per day: " + getWorkHoursPerDay() + '\n' +
                "Salary per hour: " + this.calculateMoney() + '\n';
    }

//    private void printWeekSalary() {
//        System.out.println("Week Salary: " + getWeekSalary());
//    }
}
