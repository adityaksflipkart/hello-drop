package com.flpkrt.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity(name = "bankdetails")
//@DiscriminatorValue("bd")
public class BankDetails extends BillingDetail{

    @NotNull
    private String accountNumber;
    private String accountType;
    @NotNull
    @NotEmpty
    private String bankName;
    private String iifcCode;
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIifcCode() {
        return iifcCode;
    }

    public void setIifcCode(String iifcCode) {
        this.iifcCode = iifcCode;
    }

    @Override
    public String toString() {
        return super.toString()+" BankDetails{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", bankName='" + bankName + '\'' +
                ", iifcCode='" + iifcCode + '\'' +
                '}';
    }
}
