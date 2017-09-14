package com.flpkrt.entity2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class NewAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String streetName;
    private String houseNumber;
    private String city;
    private String state;

    public int getId() {
        return id;
    }

    public NewAddress setId(int id) {
        this.id = id;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public NewAddress setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public NewAddress setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public String getCity() {
        return city;
    }

    public NewAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public NewAddress setState(String state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        return "NewAddress{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
