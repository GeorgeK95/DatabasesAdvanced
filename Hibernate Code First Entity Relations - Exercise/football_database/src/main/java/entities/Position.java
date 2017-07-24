package entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/22/2017.
 */
@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 3, unique = true, nullable = false)
    private String positionInicials;
    private String description;

    @OneToMany(mappedBy = "position")
    private Set<Player> players;

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public String getPositionInicials() {
        return positionInicials;
    }

    public void setPositionInicials(String positionInicials) {
        this.positionInicials = positionInicials;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
