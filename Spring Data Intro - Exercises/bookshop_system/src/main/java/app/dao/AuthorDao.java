package app.dao;

import app.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
/*@Repository
@Transactional*/
public interface AuthorDao extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author AS a inner join a.books AS b WHERE YEAR(b.releaseDate) < 1990")
    List<Author> findAllAuthorsWithAtLeastOneBookAfter1990();

}
