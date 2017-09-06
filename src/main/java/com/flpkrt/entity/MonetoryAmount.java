package com.flpkrt.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

public class MonetoryAmount implements Serializable{
    private BigDecimal amount;
    private Currency unit;

    public MonetoryAmount(BigDecimal amount, Currency unit) {
        this.amount = amount;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MonetoryAmount that = (MonetoryAmount) o;

        if (!amount.equals(that.amount)) return false;
        return unit.equals(that.unit);
    }

    @Override
    public int hashCode() {
        int result = amount.hashCode();
        result = 31 * result + unit.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return  amount + " " + unit;
    }
    public static MonetoryAmount fromString(String price){
        String tok[]=price.split(" ");
        return new MonetoryAmount(new BigDecimal(tok[0]),Currency.getInstance(tok[1]));
    }
}
