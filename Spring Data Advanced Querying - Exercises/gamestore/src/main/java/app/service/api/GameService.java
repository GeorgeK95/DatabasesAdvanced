package app.service.api;

import app.entities.User;

import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public interface GameService<Game, Long> extends ServiceInterface<Game, Long> {
    app.entities.Game findGameByTitle(String title);
    List<app.entities.Game> findGameByOwners(Set<User> owner);
}
