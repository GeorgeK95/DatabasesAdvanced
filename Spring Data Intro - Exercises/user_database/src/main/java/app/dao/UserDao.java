package app.dao;

import app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    @Query("select concat(u.userName, ' ',u.email)\n" +
            "from User u\n" +
            "WHERE u.email LIKE concat('%','',:email)")
    List<String> getUsersByEmailProvider(@Param(value = "email") String email);

    @Query("select count(u)\n" +
            "from User u\n" +
            "WHERE u.profilePicture < :width")
    Long getUsersCountWithBiggerPicture(@Param(value = "width") byte[] param);

    @Query("select u\n" +
            "from User as u\n" +
            "where u.lastTimeLoggedIn > :date")
    List<User> getInnactiveUsers(@Param(value = "date") Date date);

    @Query("select u\n" +
            "from User u\n" +
            "where u.isDeleted = true")
    List<User> findDeletedUsers();
}
