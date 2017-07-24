package entities;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/22/2017.
 */
@Entity
@Table(name = "base_account")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountNumber;
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BaseAccount() {
    }

    public BaseAccount(String accountNumber, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void depositMoney(BigDecimal money) {
        this.balance = this.balance.add(money);
    }

    public void withdrawMoney(BigDecimal money) {
        this.balance = this.balance.subtract(money);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
