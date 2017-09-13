package com.flpkrt.entity;

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

  @ElementCollection
  @CollectionTable(name = "Image",joinColumns = {@JoinColumn(name="itemid")})
  @MapKeyColumn(name = "filename")
  private Map<String,Image> images=new HashMap<String,Image>();

    public  Map<String,Image>getImages() {
        return images;
    }

    public void setImages(Map<String,Image> images) {
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
