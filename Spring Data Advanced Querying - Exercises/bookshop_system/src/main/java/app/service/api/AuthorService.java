package app.service.api;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
public interface AuthorService<Author, Long> extends ServiceInterface<Author, Long> {
    List<Author> findAllAuthorsWithAtLeastOneBookAfter1990();

    List<app.domain.Author> findAllAuthorsByFirstNameEndsWith(String string);

    List<Object[]> totalBooksCopied();

    Integer booksCountByAuthor(String first, String last) throws SQLException;
//    Author fancyMethodName(arg1, arg2);
}
