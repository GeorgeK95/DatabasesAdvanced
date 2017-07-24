package app.dao;

import app.domain.impl.ProductionBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by George-Lenovo on 7/23/2017.
 */
@Repository
@Transactional
public interface ProductionBatchDao extends JpaRepository<ProductionBatch, Long> {
    List<ProductionBatch> findByName(String name);
}
