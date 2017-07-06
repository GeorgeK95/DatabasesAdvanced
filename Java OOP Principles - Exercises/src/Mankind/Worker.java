package Mankind;

/**
 * Created by George-Lenovo on 7/6/2017.
 */
public class Worker extends Human {
    private double weekSalary;
    private double hoursPerDay;

    public Worker(String firstName, String lastName, double weekSalary, double hoursPerDay) {
        super(firstName, lastName);
        this.setWeekSalary(weekSalary);
        this.setHoursPerDay(hoursPerDay);
    }

    @Override
    protected void setLastName(String lastName) {
        if (lastName.length() > 3) {
            super.setLastName(lastName);
        } else {
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
    }

    public double getWeekSalary() {
        return weekSalary;
    }

    public void setWeekSalary(double weekSalary) {
        if (weekSalary > 10) {
            this.weekSalary = weekSalary;
        } else {
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
    }

    public double getHoursPerDay() {
        return hoursPerDay;
    }

    public void setHoursPerDay(double hoursPerDay) {
        if (hoursPerDay >= 1 && hoursPerDay <= 12) {
            this.hoursPerDay = hoursPerDay;
        } else {
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
    }

    public double calculateSalaryPerHour() {
        return this.getWeekSalary() / this.getHoursPerDay() / 7;
    }
}
