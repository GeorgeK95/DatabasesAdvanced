package app.dao;

import app.entities.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanetDao extends JpaRepository<Planet, Long> {
    Planet findByName(String homePlanetName);
    List<Planet> findByOriginAnomalyNull();
}
