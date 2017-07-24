package entities;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity
@Table(name = "course")
//@DiscriminatorValue(value = "Course")
public class Course /*extends Person*/ {
    private Long id;
    private String nameDescription;
    private LocalDate startDate;
    private LocalDate endDate;
    private int credits;
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Course() {
    }

    public Course(String nameDescription, LocalDate startDate, LocalDate endDate, int credits) {
        this.nameDescription = nameDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        this.credits = credits;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDescription() {
        return nameDescription;
    }

    public void setNameDescription(String nameDescription) {
        this.nameDescription = nameDescription;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }
}
