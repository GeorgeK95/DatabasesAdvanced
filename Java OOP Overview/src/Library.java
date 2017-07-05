import java.util.ArrayList;
import java.util.List;

class Library {
    public String name;
    public List<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<Book>();
    }

}