package app.model;

import app.annotations.email.Email;
import app.annotations.password.Password;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userName;
    @Password(containSymbol = false, containDigit = false, containUpperCaseLetter = false)
    private String password;
    @Column(nullable = false)
    @Email
    private String email;
    private byte[] profilePicture;
    private Date registeredOn;
    private Date lastTimeLoggedIn;
    private int age;
    private boolean isDeleted;

    //new
    @Transient
    private String fullName;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    //friends
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_friends", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    private Set<User> friends;


    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToOne
    @JoinColumn(name = "born_town_id")
    private Town bornTown;
    @OneToOne
    @JoinColumn(name = "living_town_id")
    private Town livingTown;

    public Town getBornTown() {
        return bornTown;
    }

    public void setBornTown(Town bornTown) {
        this.bornTown = bornTown;
    }

    public Town getLivingTown() {
        return livingTown;
    }

    public void setLivingTown(Town livingTown) {
        this.livingTown = livingTown;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

//    public void setUserName(String userName) {
//        int n = userName.length();
//        if (n < 4 || n > 30) {
//            throw new IllegalArgumentException("Username length be between 4 and 30 symbols.");
//        }
//        this.userName = userName;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private void throwEmailEx() {
        throw new IllegalArgumentException("Incorrect email");
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Date getLastTimeLoggedIn() {
        return lastTimeLoggedIn;
    }

    public void setLastTimeLoggedIn(Date lastTimeLoggedIn) {
        this.lastTimeLoggedIn = lastTimeLoggedIn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 1 || age > 120) {
            throw new IllegalArgumentException("Incorrect age");
        }
        this.age = age;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
