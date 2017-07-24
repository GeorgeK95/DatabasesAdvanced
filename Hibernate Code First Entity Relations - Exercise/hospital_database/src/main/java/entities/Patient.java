package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private LocalDate dateOfBirth;
    private byte[] picture;
    private boolean hasMedicalInsurance;
    @ManyToMany
    @JoinTable(name = "patient_visitation",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "visitation_id", referencedColumnName = "id"))
    private Set<Visitation> visitation;
    @ManyToMany
    @JoinTable(name = "patient_diagnose",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "diagnose_id", referencedColumnName = "id"))
    private Set<Diagnose> diagnoses;
    @ManyToMany
    @JoinTable(name = "patient_medicaments",
            joinColumns = @JoinColumn(name = "patient_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "medicaments_id", referencedColumnName = "id"))
    private Set<Medicament> medicaments;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String address, String email, LocalDate dateOfBirth, byte[] picture, boolean hasMedicalInsurance, Set<Visitation> visitation, Set<Diagnose> diagnoses, Set<Medicament> medicaments) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setEmail(email);
        this.setDateOfBirth(dateOfBirth);
        this.setPicture(picture);
        this.setHasMedicalInsurance(hasMedicalInsurance);
        this.setVisitation(visitation);
        this.setMedicaments(medicaments);
        this.setDiagnoses(diagnoses);
    }

    public Set<Visitation> getVisitation() {
        return visitation;
    }

    public void setVisitation(Set<Visitation> visitation) {
        if (visitation == null) {
            throw new NullPointerException("Visitation can't be null");
        }
        this.visitation = visitation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (visitation == null) {
            throw new NullPointerException("Id can't be null");
        }
        this.id = id;
    }

    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        if (diagnoses == null) {
            throw new NullPointerException("DiagnoseSet can't be null");
        }
        this.diagnoses = diagnoses;
    }

    public Set<Medicament> getMedicaments() {
        return medicaments;
    }

    public void setMedicaments(Set<Medicament> medicaments) {
        if (medicaments == null) {
            throw new NullPointerException("MedicamentsSet can't be null");
        }
        this.medicaments = medicaments;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            throw new NullPointerException("First name can't be null");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            throw new NullPointerException("Last name can't be null");
        }
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null) {
            throw new NullPointerException("Address can't be null");
        }
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null) {
            throw new NullPointerException("Email can't be null");
        }
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (dateOfBirth == null) {
            throw new NullPointerException("Date can't be null");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        if (picture == null) {
            throw new NullPointerException("Picture can't be null");
        }
        this.picture = picture;
    }

    public boolean isHasMedicalInsurance() {
        return hasMedicalInsurance;
    }

    public void setHasMedicalInsurance(boolean hasMedicalInsurance) {
        this.hasMedicalInsurance = hasMedicalInsurance;
    }
}
