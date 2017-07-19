package app.app;

import app.domain.book.Author;
import app.domain.book.Book;
import app.domain.book.Category;
import app.service.api.book.AuthorService;
import app.service.impl.book.AuthorServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public class BookshopSystem {
    private static AuthorService<Author, Long> authorService = new AuthorServiceImpl();

    public static void main(String[] args) {
        Author author = new Author("Karl", "Mai");

        Set<Category> categories = new HashSet<>();
        categories.add(new Category("Adventure"));
        categories.add(new Category("Wild West"));
        categories.add(new Category("Indians"));

        Book vinetu = new Book("Vinetu 1", author);
        vinetu.setCategories(categories);

        Set<Book> books = new HashSet<>();
        books.add(vinetu);

        author.setAuthorsBooks(books);
        authorService.save(author);

        List<Author> authorList = authorService.findAll(Author.class);
        System.out.println(authorList);
    }
}
