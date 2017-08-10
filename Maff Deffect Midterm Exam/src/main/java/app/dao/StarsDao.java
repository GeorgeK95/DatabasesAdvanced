package app.dao;

import app.entities.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarsDao extends JpaRepository<Star, Long> {
    Star findByName(String name);


}
