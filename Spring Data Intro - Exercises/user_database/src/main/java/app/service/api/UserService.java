package app.service.api;

import java.util.Date;
import java.util.List;

/**
 * Created by George-Lenovo on 7/25/2017.
 */
public interface UserService<User, Long> extends ServiceInterface<User, Long> {
    List<String> getUsersByEmailProvider(String email);

    Long getUsersCountWithBiggerPicture(byte[] param);

    List<User> getInnactiveUsers(Date date);

    List<User> findDeletedUsers();
}
