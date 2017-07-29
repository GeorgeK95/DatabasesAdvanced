package app.dao;

import app.entities.Game;
import app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Repository
public interface GameDao extends JpaRepository<Game, Long> {
    Game findGameByTitle(String title);


    List<Game> findGameByOwners(Set<User> owner);
}
