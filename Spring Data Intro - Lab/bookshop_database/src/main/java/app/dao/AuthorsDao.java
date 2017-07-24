package app.dao;

import app.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by George-Lenovo on 7/17/2017.
 */
@Repository
@Transactional
public interface AuthorsDao extends JpaRepository<Author, Long> {
    Author findAuthorByFirstName(String firstName);

    Author findAuthorByLastName(String lastName);
}
