package app.dao;

import app.entities.Anomaly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnomalyDao extends JpaRepository<Anomaly,Long> {
    @Query("select a from Anomaly a where a.victims.size = (select max(a1.victims.size) from Anomaly a1)")
    Anomaly biggestAnomaly();
}
