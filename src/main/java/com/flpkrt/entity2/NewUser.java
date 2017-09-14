package com.flpkrt.entity2;

import javax.persistence.*;

@Entity
public class NewUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String firstName;
    private String lastName;

    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY,optional = false,cascade = CascadeType.PERSIST)
    private NewAddress address;

    public int getId() {
        return id;
    }

    public NewUser setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public NewUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public NewUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public NewAddress getAddress() {
        return address;
    }

    public NewUser setAddress(NewAddress address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "UserNew{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
