package app.service.impl;

import app.dao.UserDao;
import app.entities.Game;
import app.entities.User;
import app.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Service
public class UserServiceImpl implements UserService<User, Long> {
    @Autowired
    private UserDao dao;

    @Override
    public User findById(Long id) {
        return dao.findOne(id);
    }

    @Override
    public void remove(User object) {
        dao.delete(object);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public void save(User object) {
        dao.save(object);
    }

    @Override
    public User findUserByEmailAndPassword(String email, String password) {
        return dao.findUserByEmailAndPassword(email, password);
    }

    @Override
    public List<User> findUserByIsLoggedInTrue() {
        return dao.findUserByIsLoggedInTrue();
    }

    @Override
    public Set<Game> getGameFromUser(String gameTitle, Long id) {
        return dao.getGameFromUser(gameTitle,id);
    }
}
