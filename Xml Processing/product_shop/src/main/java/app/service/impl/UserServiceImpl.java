package app.service.impl;

import app.dao.UserDao;
import app.entities.User;
import app.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by George-Lenovo on 8/1/2017.
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
    public void saveList(List<User> object) {
        for (User user : object) {
            dao.save(user);
        }
    }

    @Override
    public Set<User> successfullySoldProducts() {
        return dao.successfullySoldProducts();
    }

    @Override
    public Set<User> usersAndProducts() {
        return dao.usersAndProducts();
    }
}
