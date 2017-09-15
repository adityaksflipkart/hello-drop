package com.flpkrt.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinTable(name = "itembidmap",joinColumns = @JoinColumn(name="bidid"),inverseJoinColumns = @JoinColumn(name="itemid"))
    @JoinColumn(name="itemid")
    private Item item;

    private Date bidDate;

    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getBidDate() {
        return bidDate;
    }

    public void setBidDate(Date bidDate) {
        this.bidDate = bidDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "BId{" +
                "id=" + id +
                ", item=" + item +
                ", bidDate=" + bidDate +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bid bid = (Bid) o;

        if (id != bid.id) return false;
        if (amount != bid.amount) return false;
        if (!item.equals(bid.item)) return false;
        return bidDate.equals(bid.bidDate);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + item.hashCode();
        result = 31 * result + bidDate.hashCode();
        result = 31 * result + amount;
        return result;
    }
}
