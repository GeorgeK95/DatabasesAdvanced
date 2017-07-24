package entities;

import javax.persistence.*;

/**
 * Created by George-Lenovo on 7/19/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String roomType;
    @Column(length = 1000)
    private String notes;

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
