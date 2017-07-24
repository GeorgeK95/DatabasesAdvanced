package app.service.api;

import java.util.List;

/**
 * Created by George-Lenovo on 7/23/2017.
 */
public interface ProductionBatchService<ProductionBatch, Long> extends ServiceInterface<ProductionBatch, Long> {
    List<ProductionBatch> findBatchByName(String name);
}
