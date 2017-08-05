package app.dto;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by George-Lenovo on 8/4/2017.
 */
@XmlRootElement(name = "suppliers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SuppliersDto {
    @Expose
    @XmlElement(name = "supplier")
    private List<SupplierDto> supplier;

    public List<SupplierDto> getSupplier() {
        return supplier;
    }

    public void setSupplier(List<SupplierDto> supplier) {
        this.supplier = supplier;
    }
}
