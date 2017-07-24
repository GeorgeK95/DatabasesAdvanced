package app.console;

import app.domain.Author;
import app.domain.Book;
import app.domain.Category;
import app.service.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Component
public class BookShop implements CommandLineRunner {
    @Autowired
    private AuthorService authorService;

    @Override
    public void run(String... strings) throws Exception {
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
