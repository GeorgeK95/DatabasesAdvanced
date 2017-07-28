package app.dao;

import app.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Repository
@Transactional
public interface BookDao extends JpaRepository<Book, Long> {
    @Query("select b.title from Book b where YEAR(b.releaseDate) > 2000")
    List<String> findBooksAfter2000();

    @Query("select b from Book b where b.author.firstName = 'George' and b.author.lastName = 'Powell'")
    List<Book> findAllBooksByGeorgePowell();

    List<Book> findAllBooksByAgeRestriction(AgeRestriction ageRestriction);

    @Query("select b from Book b where b.editionType = :editionType and b.copies < 5000")
    List<Book> findAllBooksByEditionType(@Param(value = "editionType") EditionType editionType);

    @Query("select b.title, b.price from Book b where b.price < 5 or b.price > 40")
    List<Object[]> findTitlesAndPrice();

    List<Book> findAllBooksByReleaseDateIsNot(Date date);

    List<Book> findAllBooksByCategoriesIn(List<Category> categories);

    List<Book> findAllBooksByReleaseDateBefore(Date date);

    List<Book> findAllBooksByTitleContains(String str);

    List<app.domain.Book> findAllBooksByAuthor_LastNameStartsWith(String str);

    @Query("select count(b) from Book as b where char_length(b.title) > :num")
    Integer countBooks(@Param(value = "num") Long number);

    @Query("select b from Book b where b.title = :title")
    ReducedBook findAllBooksByTitle(@Param(value = "title") String title);

    @Query("select count(b) from Book b where b.releaseDate > :date")
    Integer findAllBooksByReleaseDateAfter(@Param(value = "date") Date date);

    @Query("update Book set copies = copies + :param where releaseDate > :date")
    @Modifying
    void increaseBookCopies(@Param(value = "param") int copiesCount, @Param(value = "date") Date date);


    @Query("delete from Book where copies < :param")
    @Modifying
    void removeBooksWithLowerCopies(@Param(value = "param") int copiesCount);

    @Query("select count(b) from Book b where copies < :param")
    Integer findBooksCountWithLowerCopies(@Param(value = "param") int copiesCount);

}
