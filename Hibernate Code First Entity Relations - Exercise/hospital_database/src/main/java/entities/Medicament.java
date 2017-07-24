package entities;

import javax.persistence.*;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Medicament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

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
}
