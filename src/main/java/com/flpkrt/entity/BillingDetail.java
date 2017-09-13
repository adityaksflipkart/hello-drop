package com.flpkrt.entity;

import net.bytebuddy.dynamic.loading.ClassInjector;
import org.hibernate.annotations.DiscriminatorFormula;
import org.hibernate.usertype.UserCollectionType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "bdtype")
@Entity
public abstract class BillingDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @ManyToOne(fetch = FetchType.EAGER,optional = false,targetEntity = User.class)
    @JoinColumn(name = "user_userId",nullable = false,updatable = false)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(insertable = false,updatable = false)
    private Integer user_userId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BillingDetail{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
