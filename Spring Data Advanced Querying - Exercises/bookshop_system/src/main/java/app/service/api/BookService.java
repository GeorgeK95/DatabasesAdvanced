package app.service.api;

import app.domain.AgeRestriction;
import app.domain.Category;
import app.domain.EditionType;
import app.domain.ReducedBook;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
public interface BookService<Book, Long> extends ServiceInterface<Book, Long> {
    List<String> findBooksAfter2000();

    List<Book> findAllBooksByGeorgePowell();

    List<app.domain.Book> findAllBooksByRestriction(AgeRestriction ageRestriction);

    List<app.domain.Book> findGoldTypeBooks(EditionType gold);

    List<Object[]> findTitlesAndPrice();

    List<app.domain.Book> findAllBooksByReleaseDateIsNot(Date date);

    List<app.domain.Book> findAllBooksByCategoriesIn(List<Category> categories);

    List<app.domain.Book> findAllBooksByReleaseDateBefore(Date date);

    List<app.domain.Book> findAllBooksByTitleContains(String str);

    List<app.domain.Book> findAllBooksByAuthor_LastNameStartsWith(String str);

    Integer countBooks(java.lang.Long number);

    ReducedBook findAllBooksByTitle(String title);

    Integer findAllBooksByReleaseDateAfter(Date date);

    void increaseBookCopies(int copiesCount, Date date);

    void removeBooksWithLowerCopies(@Param(value = "param") int copiesCount);

    Integer findBooksCountWithLowerCopies(@Param(value = "param") int copiesCount);

}
