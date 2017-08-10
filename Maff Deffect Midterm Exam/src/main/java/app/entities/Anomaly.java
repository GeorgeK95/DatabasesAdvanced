package app.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Anomaly {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "origin_planet_id", nullable = false)
    private Planet originPlanet;

    @NotNull
    @OneToOne
    @JoinColumn(name = "teleport_planet_id", nullable = false)
    private Planet teleportPlanet;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "anomaly_victims", joinColumns = {@JoinColumn(name = "anomaly_id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id")})
    private Set<Person> victims;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Planet getOriginPlanet() {
        return originPlanet;
    }

    public void setOriginPlanet(Planet originPlanet) {
        this.originPlanet = originPlanet;
    }

    public Planet getTeleportPlanet() {
        return teleportPlanet;
    }

    public void setTeleportPlanet(Planet teleportPlanet) {
        this.teleportPlanet = teleportPlanet;
    }

    public Set<Person> getVictims() {
        return victims;
    }

    public void setVictims(Set<Person> victims) {
        this.victims = victims;
    }

    public void addVictim(Person p) {
        this.victims.add(p);
    }
}
