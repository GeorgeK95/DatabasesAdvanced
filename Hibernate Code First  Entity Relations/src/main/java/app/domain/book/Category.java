package app.domain.book;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
@Entity
@Table(name = "category")
public class Category {
    private int id;
    private String name;
    private Set<Book> books;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", books=" + books +
                '}';
    }

    public Category(String name) {
        this.setName(name);
    }

    public Category() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "categories")
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
