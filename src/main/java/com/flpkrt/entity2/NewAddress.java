package com.flpkrt.entity2;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.net.UnknownServiceException;

@Entity
public class NewAddress {
    @Id
    @GeneratedValue(generator = "addresskeygen")
    @GenericGenerator(name = "addresskeygen",strategy = "foreign",
            parameters = @org.hibernate.annotations.Parameter(name="property",value = "newuser"))
    private int id;

    private String streetName;
    private String houseNumber;
    private String city;
    private String state;


    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    private NewUser user;

    public NewUser getUser() {
        return user;
    }

    public void setUser(NewUser user) {
        this.user = user;
    }

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
