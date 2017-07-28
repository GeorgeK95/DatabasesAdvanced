package app.dao;

import app.domain.Author;
import app.domain.Book;
import app.service.api.AuthorService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
/*@Repository
@Transactional*/
public interface AuthorDao extends JpaRepository<Author, Long>/*, AuthorService<Author,Long> */{
    @Query("SELECT a FROM Author AS a inner join a.books AS b WHERE YEAR(b.releaseDate) < 1990")
    List<Author> findAllAuthorsWithAtLeastOneBookAfter1990();

    List<Author> findAllAuthorsByFirstNameEndsWith(String string);

    @Query("select concat(a.firstName,'',a.lastName), sum(b.copies) from Author a " +
            "inner join a.books b " +
            "group by a " +
            "order by sum(b.copies) desc")
    List<Object[]> totalBooksCopied();

//    @Query("call booksCount(:fName,:lName )")
//    Integer booksCountByAuthor(@Param(value = "fName") String first, @Param(value = "lName") String last);
}
