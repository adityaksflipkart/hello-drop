package com.flpkrt.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private int userid;

    private String deliveryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public Delivery setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
        return this;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", userid=" + userid +
                ", deliveryName='" + deliveryName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Delivery delivery = (Delivery) o;

        if (id != delivery.id) return false;
        if (userid != delivery.userid) return false;
        return deliveryName.equals(delivery.deliveryName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userid;
        result = 31 * result + deliveryName.hashCode();
        return result;
    }
}
