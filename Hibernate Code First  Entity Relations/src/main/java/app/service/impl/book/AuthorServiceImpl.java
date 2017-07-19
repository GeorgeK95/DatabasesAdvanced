package app.service.impl.book;

import app.domain.book.Author;
import app.domain.book.Book;
import app.service.api.book.AuthorService;
import app.transaction.Command;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public final class AuthorServiceImpl extends AbstractService implements AuthorService {

    public AuthorServiceImpl() {
        super();
    }


    @Override
    public Book bestSeller(Author author) {
        Set<Book> books = author.getAuthorsBooks();
        return (Book) books.stream().sorted(Comparator.comparing(Book::getPrice).reversed()).limit(1);
    }

    @Override
    public Author findByName(String name) {
        return (Author) runInTransaction(new Command<Author>() {
            @Override
            public Author execute() {
                List<Author> all = dao.findAll(Author.class);
                return all.stream().filter(x -> x.getFirstName().equals(name)).findFirst().orElse(null);
            }
        });
    }

    @Override
    public Author findByName(String fName, String lName) {
        return (Author) runInTransaction(new Command<Author>() {
            @Override
            public Author execute() {
                List<Author> all = dao.findAll(Author.class);
                return all.stream().filter(x -> x.getFirstName().equals(fName) && x.getLastName().equals(lName)).findFirst().orElse(null);
            }
        });
    }
}
