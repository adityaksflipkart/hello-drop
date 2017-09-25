package com.flpkrt.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Converts(value = {@Convert(attributeName = "basecost",converter = MonetoryConvertor.class),
    @Convert(attributeName = "address.pincode",converter = ZipCodeConvertor.class),
    @Convert(attributeName = "deliveryAddress.pincode",converter = ZipCodeConvertor.class)})
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int userId;

    @NotNull
    @NotEmpty
    private String firstname;
    @NotNull
    @NotEmpty
    private String lastname;

    private UserAddress address;

    @AttributeOverrides(value = {@AttributeOverride(name = "street",column = @Column(name="deliverystreet")),
            @AttributeOverride(name = "city",column = @Column(name="deliverycity")),
            @AttributeOverride(name = "state",column = @Column(name="deliverystate")),
            @AttributeOverride(name = "country",column = @Column(name="deliverycountry")),
            @AttributeOverride(name ="pincode.zipcode" ,column = @Column(name="deliveryzipcode")),
            @AttributeOverride(name="deliveries",column = @Column(name="deliveryadd"))})
    private UserAddress deliveryAddress;

    @NotNull
    @Convert(converter = MonetoryConvertor.class)
    @Column(name = "basecost")
    private MonetoryAmount amount;




    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private Set<BillingDetail> billingDetail;

    public Set<BillingDetail> getBillingDetail() {
        return billingDetail;
    }

    public void setBillingDetail(Set<BillingDetail> billingDetail) {
        this.billingDetail = billingDetail;
    }

    public MonetoryAmount getAmount() {
        return amount;
    }

    public void setAmount(MonetoryAmount amount) {
        this.amount = amount;
    }

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public UserAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(UserAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String
    toString() {
        return "User{" +
                "id=" + userId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address=" + address +
                ", deliveryAddress=" + deliveryAddress +
                ", amount=" + amount +
                ", billingDetail=" + billingDetail +
                '}';
    }
}
