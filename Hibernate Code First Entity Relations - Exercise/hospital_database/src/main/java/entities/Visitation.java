package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Visitation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Column(nullable = false)
    private LocalDate date;
//    @Column(nullable = false)
    private String comments;

    @ManyToMany(mappedBy = "visitation")
    private Set<Patient> patients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
