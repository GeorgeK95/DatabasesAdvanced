package app.services.api;

import app.dto.bindings.xml.ProductImportXmlDto;

public interface ProductService<Branch, Long> extends ServiceInterface<Branch, Long> {
    void persist(ProductImportXmlDto productDto);
}
