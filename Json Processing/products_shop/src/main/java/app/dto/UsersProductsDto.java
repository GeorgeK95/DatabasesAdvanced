package app.dto;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by George-Lenovo on 8/2/2017.
 */
public class UsersProductsDto {
    @Expose
    private int usersCount;
    @Expose
    private List<UserDto> users;

    public int getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(int usersCount) {
        this.usersCount = usersCount;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
