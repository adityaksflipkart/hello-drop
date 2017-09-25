package com.flpkrt.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Embeddable
public class UserAddress {

    private String street;
    private String city;
    private String state;
    private String country;

    @NotNull
    private ZipCode pincode;


    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    //@JoinTable(name = "userdeliverymap",joinColumns = @JoinColumn(name="userid"),inverseJoinColumns = @JoinColumn(name = "deliveryid"))
    @JoinColumn(name="userid")
    private Set<Delivery> deliveries=new HashSet<Delivery>();

    public Set<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<Delivery> deliveries) {
        this.deliveries = deliveries;
    }

    public ZipCode getPincode() {
        return pincode;
    }

    public void setPincode(ZipCode pincode) {
        this.pincode = pincode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pincode=" + pincode +
                ", deliveries=" + deliveries +
                '}';
    }
}
