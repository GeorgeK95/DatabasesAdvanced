package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by George-Lenovo on 7/21/2017.
 */

@Entity
@Table(name = "bank_account")
//@DiscriminatorValue(value = "Bank account")
public class BankAccount extends BillingDetail {
    private String bankName;
    private String swiftCode;

    public BankAccount() {
    }

    public BankAccount(String bankName, String swiftCode) {
        this.bankName = bankName;
        this.swiftCode = swiftCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
