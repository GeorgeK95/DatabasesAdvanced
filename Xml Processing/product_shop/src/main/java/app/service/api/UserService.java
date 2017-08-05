package app.service.api;

import java.util.Set;

/**
 * Created by George-Lenovo on 8/1/2017.
 */
public interface UserService<User, Long> extends ServiceInterface<User, Long> {
    Set<app.entities.User> successfullySoldProducts();
    Set<app.entities.User> usersAndProducts();
}
