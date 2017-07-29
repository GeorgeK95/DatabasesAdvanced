package app.service.api;

import java.util.List;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public interface UserService<User, Long> extends ServiceInterface<User, Long> {
    User findUserByEmailAndPassword(String email, String password);
    List<app.entities.User> findUserByIsLoggedInTrue();
}
