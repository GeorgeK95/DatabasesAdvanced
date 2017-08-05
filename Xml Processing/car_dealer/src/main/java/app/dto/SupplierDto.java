package app.dto;

import com.google.gson.annotations.Expose;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@XmlRootElement(name = "supplier")
@XmlAccessorType(XmlAccessType.FIELD)
public class SupplierDto {
    @Expose
    @XmlAttribute
    private Long id;

    @Expose
    @XmlAttribute
    private String name;
//    @Expose
//    @XmlAttribute(name = "is-importer")
//    private boolean isImporter;

    @Expose
    @XmlAttribute(name = "parts-count")
    private int partsCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        this.isImporter = importer;
    }
*/

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//
//    public int getPartsCount() {
//        return partsCount;
//    }
//
//    public void setPartsCount(int partsCount) {
//        this.partsCount = partsCount;
//    }
//    @Expose
//    private int partsCount;


}
