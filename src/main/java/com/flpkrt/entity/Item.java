package com.flpkrt.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int itemid;
    @NotNull
    private String name;
    private String  companyname ;
    private Measurement measurement;
    private Weight weighing;

    @OneToMany(mappedBy = "item",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Set<Bid> bids=new HashSet<Bid>();

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    @ElementCollection
    @CollectionTable(name = "Image",joinColumns = {@JoinColumn(name="itemid")})
    private Map<ImageName,Image> images=new HashMap<ImageName,Image>();

    public  Map<ImageName,Image>getImages() {
        return images;
    }

    public void setImages(Map<ImageName,Image> images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public Weight getWeighing() {
        return weighing;
    }

    public void setWeighing(Weight weighing) {
        this.weighing = weighing;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + itemid +
                ", name='" + name + '\'' +
                ", companyname='" + companyname + '\'' +
                ", measurement=" + measurement +
                ", weighing=" + weighing +
                '}';
    }
}
