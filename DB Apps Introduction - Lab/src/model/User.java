package model;

import annotations.Column;
import annotations.Id;

import java.time.LocalDate;

/**
 * Created by George-Lenovo on 7/12/2017.
 */
public class User {
    @Id
    private long id;
    @Column(name = "user_name")
    private String name;
    private int age;
    @Column(name = "registration_date")
    private LocalDate dateOfRegistration;

    @Override
    public String toString() {
        return "Id: " + this.id + " \nName: " + this.name + " \nAge: " + this.age + " \nDate: " + this.dateOfRegistration;
    }

    public User() {
    }

    public User(String name, int age, LocalDate dateOfRegistration) {
        this.setName(name);
        this.setAge(age);
        this.setDateOfRegistration(dateOfRegistration);
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
