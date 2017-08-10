package app.dao;

import app.entities.SolarSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolarSystemsDao extends JpaRepository<SolarSystem, Long> {
    SolarSystem findByName(String name);
}
