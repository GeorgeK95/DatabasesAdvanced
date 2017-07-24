package entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/19/2017.
 */
@SuppressWarnings("ALL")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class StoreLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    private String locationName;
    @OneToMany(mappedBy = "storeLocation", cascade = CascadeType.ALL)
    private Set<Sale> locationSales;

    public StoreLocation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Set<Sale> getLocationSales() {
        return locationSales;
    }

    public void setLocationSales(Set<Sale> sales) {
        this.locationSales = sales;
    }
}
