package app.service.impl;

import app.dao.UserDao;
import app.model.User;
import app.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
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
    public List<String> getUsersByEmailProvider(String email) {
        return dao.getUsersByEmailProvider(email);
    }

    @Override
    public Long getUsersCountWithBiggerPicture(byte[] param) {
        return dao.getUsersCountWithBiggerPicture(param);
    }

    @Override
    public List<User> getInnactiveUsers(Date date) {
        return dao.getInnactiveUsers(date);
    }

    @Override
    public List<User> findDeletedUsers() {
        return dao.findDeletedUsers();
    }

}
