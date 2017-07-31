package app.service.impl;

import app.dao.GameDao;
import app.entities.Game;
import app.entities.User;
import app.service.api.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Service
public class GameServiceImpl implements GameService<Game, Long> {
    @Autowired
    private GameDao dao;

    @Override
    public Game findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(Game object) {
        dao.delete(object);
    }

    @Override
    public List<Game> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(Game object) {
        dao.save(object);
    }

    @Override
    public Game findGameByTitle(String title) {
        return dao.findGameByTitle(title);
    }

    @Override
    public List<Game> findGameByOwners(Set<User> owner) {
        return dao.findGameByOwners(owner);
    }
}
