package app.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @OneToOne
    @JoinColumn(name = "sun_id", nullable = false)
    private Star sun;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "system_id", nullable = false)
    private SolarSystem solarSystem;


    @OneToOne(mappedBy = "originPlanet")
    private Anomaly originAnomaly;

    public Anomaly getOriginAnomaly() {
        return originAnomaly;
    }

    public void setOriginAnomaly(Anomaly originAnomaly) {
        this.originAnomaly = originAnomaly;
    }

    public Star getSun() {
        return sun;
    }

    public void setSun(Star sun) {
        this.sun = sun;
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

    public SolarSystem getSolarSystem() {
        return solarSystem;
    }

    public void setSolarSystem(SolarSystem solarSystem) {
        this.solarSystem = solarSystem;
    }
}
