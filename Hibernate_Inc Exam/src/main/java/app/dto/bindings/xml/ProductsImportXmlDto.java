package app.dto.bindings.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsImportXmlDto {
    @XmlElement(name = "product")
    private List<ProductImportXmlDto> products;

    public List<ProductImportXmlDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductImportXmlDto> products) {
        this.products = products;
    }
}
