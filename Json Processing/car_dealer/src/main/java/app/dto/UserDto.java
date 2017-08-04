package app.dto;

import com.google.gson.annotations.Expose;

/**
 * Created by George-Lenovo on 7/29/2017.
 */
public class UserDto {
    @Expose
    private String fullName;
    @Expose
    private String email;
    @Expose
    private String password;

    public String getFullName() {
        return fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
