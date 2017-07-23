package app.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
@Entity
@Table(name = "author")
public class Author {

    private Long id;
    private String firstName;
    private String lastName;
    private Set<Book> authorsBooks;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", authorsBooks=" + authorsBooks +
                '}';
    }

    public Author(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public Author() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
//    @Transient
    public Set<Book> getAuthorsBooks() {
        return authorsBooks;
    }

    public void setAuthorsBooks(Set<Book> authorsBooks) {
        this.authorsBooks = authorsBooks;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
