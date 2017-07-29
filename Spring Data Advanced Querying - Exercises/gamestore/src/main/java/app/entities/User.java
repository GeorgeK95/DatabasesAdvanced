package app.entities;

import app.annotations.email.Email;
import app.annotations.password.Password;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @Column(unique = true)
    private String email;
    @Password
    private String password;
    private String fullName;
    @ManyToMany(mappedBy = "owners")
    private Set<Game> games;
    private boolean isAdmin;

    private boolean isLoggedIn;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public User() {
    }

    public User(String email, String password, String fullName, boolean isAdmin) {
        this.setEmail(email);
        this.setPassword(password);
        this.setFullName(fullName);
        this.setAdmin(isAdmin);
        this.games = new HashSet<>();
    }

    public void addGame(Game game) {
        this.games.add(game);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
