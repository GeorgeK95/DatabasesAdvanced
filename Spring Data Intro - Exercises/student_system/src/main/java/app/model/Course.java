package app.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private BigDecimal price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "courses_students", joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private Set<Student> students;

    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private Set<Resource> resources;

    public Set<Student> getStudents() {
        return students;
    }

    public long getDifferenceDays() {
        long diff = this.endDate.getTime() - this.startDate.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
