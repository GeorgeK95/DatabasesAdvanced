package app.dao;

import app.entities.Part;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
@Repository
public interface PartDao extends JpaRepository<Part,Long> {
}
