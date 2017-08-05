package app.service.api;

import java.util.List;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
public interface SupplierService<Supplier,Long> extends ServiceInterface<Supplier,Long> {
    List<app.entities.Supplier> findAllSupplierByIsImportedFalse();
}
