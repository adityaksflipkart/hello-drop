package com.flpkrt.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@SecondaryTable(name="CreditCardDetails",pkJoinColumns = @PrimaryKeyJoinColumn(name="creditCardId"))
@DiscriminatorValue("cc")
public class CreditCardDetails extends BillingDetail{

    @Column(table = "CreditCardDetails")
    private String cardNumber;

    @Temporal(TemporalType.DATE)
    @Column(table = "CreditCardDetails")
    private Date expiryDate;

    @Column(table = "CreditCardDetails")
    private String cvv;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return super.toString()+" CreditCardDetails{" +
                "cardNumber='" + cardNumber + '\'' +
                ", expiryDate=" + expiryDate +
                ", cvv='" + cvv + '\'' +
                '}';
    }
}
