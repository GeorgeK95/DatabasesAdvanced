package app.service.impl.book;

import app.domain.book.Book;
import app.service.api.book.BookService;
import app.transaction.Command;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 7/18/2017.
 */
public final class BooksServiceImpl extends AbstractService implements BookService {

    public BooksServiceImpl() {
        super();
    }

    @Override
    public Book bestSeller() {
        List<Book> all = (List<Book>) dao.findAll(Book.class).stream().sorted(Comparator.comparing(Book::getCopies).reversed()).collect(Collectors.toList());
        return (Book) all.stream().limit(1);
    }

    @Override
    public List<Book> mostExpensiveBooks(int count) {
        List<Book> all = (List<Book>) dao.findAll(Book.class).stream().sorted(Comparator.comparing(Book::getPrice).reversed()).collect(Collectors.toList());
        return all.stream().limit(count).collect(Collectors.toList());
    }

    @Override
    public Book findBookByTitle(String title) {
        return (Book) runInTransaction(new Command<Book>() {
            @Override
            public Book execute() {
                List<Book> all = dao.findAll(Book.class);
                return all.stream().filter(x -> x.getTitle().equals(title)).findFirst().orElse(null);
            }
        });
    }
}