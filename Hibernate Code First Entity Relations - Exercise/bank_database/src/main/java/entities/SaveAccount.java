package entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by George-Lenovo on 7/22/2017.
 */
@Entity
@Table(name = "save_account")
public class SaveAccount extends BaseAccount {
    private BigDecimal rate;

    public SaveAccount() {
    }

    public SaveAccount(String accountNumber, BigDecimal balance, BigDecimal rate) {
        super(accountNumber, balance);
        this.rate = rate;
    }

    public void addInterest() {
        BigDecimal bd = this.getBalance();
        bd = bd.add(bd.multiply(this.rate));
        this.setBalance(bd);
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = this.rate = rate;
    }
}
