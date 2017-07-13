package model;

import java.time.LocalDate;

/**
 * Created by George-Lenovo on 7/12/2017.
 */
public class User {
    private long id;
    private String name;
    private int age;
    private LocalDate dateOfRegistration;

    @Override
    public String toString() {
        return "Id: " + this.id + " \nName: " + this.name + " \nAge: " + this.age + " \nDate: " + this.dateOfRegistration;
    }

    public User() {
    }

    public User(String name, int age, LocalDate dateOfRegistration) {
        this.name = name;
        this.age = age;
        this.dateOfRegistration = dateOfRegistration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
}
