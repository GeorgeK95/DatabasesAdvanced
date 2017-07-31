package app.dao;

import app.entities.Game;
import app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findUserByEmailAndPassword(String email, String password);

    List<User> findUserByIsLoggedInTrue();

    @Query("select g from User u inner join u.games g where g.title = :title and u.id=:id")
    Set<Game> getGameFromUser(@Param(value = "title") String gameTitle,@Param(value = "id") Long id);

}
