package app.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean isImporter;

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    @OneToMany(mappedBy = "supplier", fetch = FetchType.EAGER)
    private Set<Part> parts;
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

    public boolean isIsImporter() {
        return isImporter;
    }

    public void setIsImporter(boolean is_imported) {
        this.isImporter = is_imported;
    }


}
