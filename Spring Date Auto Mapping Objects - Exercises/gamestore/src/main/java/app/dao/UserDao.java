package app.dao;

import app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findUserByEmailAndPassword(String email, String password);
    List<User> findUserByIsLoggedInTrue();

}
