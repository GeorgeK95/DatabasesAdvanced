package app.service.api;

import app.entities.Game;

import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public interface UserService<User, Long> extends ServiceInterface<User, Long> {
    User findUserByEmailAndPassword(String email, String password);
    List<app.entities.User> findUserByIsLoggedInTrue();
    Set<Game> getGameFromUser(String gameTitle, java.lang.Long id);
}
