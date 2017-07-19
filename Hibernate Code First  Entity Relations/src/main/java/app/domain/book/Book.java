package app.domain.book;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
@SuppressWarnings("ALL")
@Entity
@Table(name = "book")
public class Book {

    private int id;
    private String title;
    private Author author;
    private Set<Category> categories;
    private double price;
    private int copies;
    private LocalDate releaseDate;
    private String description;
    private Set<Book> relatedBooks;

    private int age_restriction;
    private int edition_type;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
//                ", author=" + author +
                ", categories=" + categories +
                ", price=" + price +
                ", copies=" + copies +
                ", releaseDate=" + releaseDate +
                ", description='" + description + '\'' +
                ", relatedBooks=" + relatedBooks +
                ", age_restriction=" + age_restriction +
                ", edition_type=" + edition_type +
                '}';
    }

    public Book() {
    }

    public Book(String s, Author author) {
        this.setTitle(s);
        this.setAuthor(author);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "title", length = 50, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne()//, cascade = CascadeType.ALL
    @JoinColumn(nullable = false, name = "authorId")
//    @JoinColumn(nullable = false, name = "authorId")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_categories", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Transient
    public Set<Book> getRelatedBooks() {
        return relatedBooks;
    }

    public void setRelatedBooks(Set<Book> relatedBooks) {
        this.relatedBooks = relatedBooks;
    }

    @Column(name = "copies")
    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Column(name = "release_date")
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Column(name = "description", length = 1000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "age_restriction")
    public int getAge_restriction() {
        return age_restriction;
    }

    public void setAge_restriction(int age_restriction) {
        this.age_restriction = age_restriction;
    }

    @Column(name = "edition_type")
    public int getEdition_type() {
        return edition_type;
    }

    public void setEdition_type(int edition_type) {
        this.edition_type = edition_type;
    }
}
