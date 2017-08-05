package app.dao;

import app.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
@Repository
public interface SupplierDao extends JpaRepository<Supplier, Long> {
    List<Supplier> findAllSupplierByIsImporterFalse();
}
