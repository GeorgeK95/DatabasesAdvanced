package app.service.api;

import java.util.List;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
public interface SaleService<Sale,Long> extends ServiceInterface<Sale,Long> {
    List<Object[]> salesWithAppliedDiscount();
}
