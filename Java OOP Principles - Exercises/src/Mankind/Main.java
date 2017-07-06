package Mankind;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 7/6/2017.
 */
public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        if (readStudents()) {
            readWorkers();
        }
    }

    private static boolean readWorkers() {
        String[] workers = in.nextLine().split(" ");
        String fName = workers[0];
        String lName = workers[1];
        double salary = Double.parseDouble(workers[2]);
        double hours = Double.parseDouble(workers[3]);
        boolean success = true;

        Worker worker = null;
        try {
            worker = new Worker(fName, lName, salary, hours);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            success = false;
        }

        if (success) {
            System.out.println(String.format("First Name: %s", worker.getFirstName()));
            System.out.println(String.format("Last Name: %s", worker.getLastName()));
            System.out.println(String.format("Week Salary: %.2f", worker.getWeekSalary()));
            System.out.println(String.format("Hours per day: %.2f", worker.getHoursPerDay()));
            System.out.println(String.format("Salary per hour: %.2f", worker.calculateSalaryPerHour()));
        }
        return success;
    }

    private static boolean readStudents() {
        String[] students = in.nextLine().split(" ");
        String fName = students[0];
        String lName = students[1];
        String number = students[2];
        boolean success = true;

        Student stud = null;
        try {
            stud = new Student(fName, lName, number);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            success = false;
        }

        if (success) {
            System.out.println(String.format("First Name: %s", stud.getFirstName()));
            System.out.println(String.format("Last Name: %s", stud.getLastName()));
            System.out.println(String.format("Faculty number: %s", stud.getNumber()));
            System.out.println();
        }
        return success;
    }
}
