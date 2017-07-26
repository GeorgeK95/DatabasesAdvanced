package app.dao;

import app.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
public interface BookDao extends JpaRepository<Book, Long> {
    @Query("select b.title from Book b where YEAR(b.releaseDate) > 2000")
    List<String> findBooksAfter2000();

    @Query("select b from Book b where b.author.firstName = 'George' and b.author.lastName = 'Powell'")
    List<Book> findAllBooksByGeorgePowell();
}
