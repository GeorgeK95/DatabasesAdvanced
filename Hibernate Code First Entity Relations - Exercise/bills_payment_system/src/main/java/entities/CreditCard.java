package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by George-Lenovo on 7/21/2017.
 */
@Entity
@Table(name = "credit_card")
//@DiscriminatorValue(value = "Credit Card")
public class CreditCard extends BillingDetail {
    private String cardType;
    private String expirationMonth;
    private int expirationYear;

    public CreditCard() {
    }

    public CreditCard(String cardType, String expirationMonth, int expirationYear) {
        this.cardType = cardType;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }
}
