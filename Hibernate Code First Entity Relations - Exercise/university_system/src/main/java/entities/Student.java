package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/21/2017.
 */

@Entity
@Table(name = "student")
//@DiscriminatorValue(value = "Student")
public class Student extends Person {
    private BigDecimal avgGrade;
    private int attendance;
    private Set<Course> courses;

    @ManyToMany
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
    public Set<Course> getCourse() {
        return courses;
    }

    public void setCourse(Set<Course> courses) {
        this.courses = courses;
    }

    public Student(BigDecimal avgGrade, int attendance) {
        this.avgGrade = avgGrade;
        this.attendance = attendance;
    }

    public Student() {
    }

    public BigDecimal getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(BigDecimal avgGrade) {
        this.avgGrade = avgGrade;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }
}
