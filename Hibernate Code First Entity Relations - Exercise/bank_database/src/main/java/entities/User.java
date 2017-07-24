package entities;

import javax.persistence.*;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 7/24/2017.
 */
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;
    private String email;

    @OneToOne(mappedBy = "user")
    private LogUser user;

    @OneToMany(mappedBy = "user")
    private Set<BaseAccount> accounts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        char firstLetter = userName.charAt(0);
        int lenght = userName.length();
        if (lenght < 3 || (firstLetter >= 48 && firstLetter <= 57) || !isValid(userName)) {
            throw new IllegalArgumentException("Incorrect username");
        }
        this.userName = userName;
    }


    private boolean isValid(String userName) {
        String pattern = "\\b[a-z0-9]*\\b";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(userName);

        return m.matches();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        boolean containLowerCaseLetter = checkForLowerCaseLetter(password);
        boolean containUpperCaseLetter = checkForUpperCaseLetter(password);
        boolean containDigit = checkForDigit(password);
        int lenght = password.length();

        if (lenght <= 6 || !containLowerCaseLetter || !containUpperCaseLetter || !containDigit) {
            throw new IllegalArgumentException("Incorrect password");
        }

        this.password = password;
    }

    private boolean checkForDigit(String password) {
        for (char c : password.toCharArray()) {
            int cc = (int) c;
            if (cc >= 48 && cc <= 57) {
                return true;
            }
        }

        return false;
    }

    private boolean checkForUpperCaseLetter(String password) {
        for (char c : password.toCharArray()) {
            int cc = (int) c;
            if (cc >= 65 && cc <= 90) {
                return true;
            }
        }

        return false;
    }

    private boolean checkForLowerCaseLetter(String password) {
        for (char c : password.toCharArray()) {
            int cc = (int) c;
            if (cc >= 97 && cc <= 122) {
                return true;
            }
        }

        return false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String pattern = "^[a-zA-Z0-9]+([\\.\\-_]*[a-zA-Z0-9]+)*@[a-zA-Z]+(\\.[a-zA-Z]+)+$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(email);

        if (m.matches()) {
            this.email = email;
        } else {
            throwEmailEx();
        }
    }

    private void throwEmailEx() {
        throw new IllegalArgumentException("Incorrect email");
    }

    public Set<BaseAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<BaseAccount> accounts) {
        this.accounts = accounts;
    }
}
