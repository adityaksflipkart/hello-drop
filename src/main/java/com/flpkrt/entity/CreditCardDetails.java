package com.flpkrt.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity(name="creditcarddetails")
//@DiscriminatorValue("cc")
public class CreditCardDetails extends BillingDetail{

    private String cardNumber;
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
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
