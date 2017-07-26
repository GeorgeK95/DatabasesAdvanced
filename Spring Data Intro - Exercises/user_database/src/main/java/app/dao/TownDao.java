package app.dao;

import app.model.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Repository
public interface TownDao extends JpaRepository<Town,Long> {
}
