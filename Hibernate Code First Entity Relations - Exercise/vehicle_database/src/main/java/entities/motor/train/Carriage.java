package entities.motor.train;

import javax.persistence.*;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity
public class Carriage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carriage_id")
    private Long id;
    private CarriageType carriageType;
    private int carriageTypeCount;

    @ManyToOne()
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicle_id")
    private Train train;

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Carriage() {
    }

    public Carriage(CarriageType carriageType, int carriageTypeCount) {
        this.carriageType = carriageType;
        this.carriageTypeCount = carriageTypeCount;
    }

    public CarriageType getCarriageType() {
        return carriageType;
    }

    public void setCarriageType(CarriageType carriageType) {
        this.carriageType = carriageType;
    }

    public int getCarriageTypeCount() {
        return carriageTypeCount;
    }

    public void setCarriageTypeCount(int carriageTypeCount) {
        this.carriageTypeCount = carriageTypeCount;
    }
}
