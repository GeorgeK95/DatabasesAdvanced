package app.dao;

import app.domain.Author;
import app.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
@Transactional
@Repository
public interface BooksDao extends JpaRepository<Book, Long> {
    Book findByTitle(String id);

    Book findByAuthor(Author author);
}
