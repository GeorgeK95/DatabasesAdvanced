package entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/22/2017.
 */
@Entity
public class CompetitionType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "type")
    private Set<Competition> competitions;

    public Set<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<Competition> competitions) {
        this.competitions = competitions;
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

    public void setName(CompetitionTypes name) {
        this.name = name.toString();
    }
}
