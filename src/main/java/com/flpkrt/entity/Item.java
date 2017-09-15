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

  /*  @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST,mappedBy = "items")
    private Set<Category> cat=new HashSet<Category>();

    public Set<Category> getCat() {
        return cat;
    }

    public void setCat(Set<Category> cat) {
        this.cat = cat;
    }*/


  @OneToMany(mappedBy = "item")
  private Set<ItemCategoryMap> catMap=new HashSet<ItemCategoryMap>();

    public Set<ItemCategoryMap> getCatMap() {
        return catMap;
    }

    public void setCatMap(Set<ItemCategoryMap> catMap) {
        this.catMap = catMap;
    }

    /*  @OneToMany(mappedBy = "item",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
            //@OrderColumn(name="oderid",nullable = false)
            //@OnDelete(action = OnDeleteAction.CASCADE)
            private Set<Bid> bids=new HashSet<Bid>();
        */
  /*  public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }
*/
    @ElementCollection
    @CollectionTable(name = "Image",joinColumns = {@JoinColumn(name="itemid")})
    private Map<ImageName,Image> images=new HashMap<ImageName,Image>();


    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

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
                "itemid=" + itemid +
                ", name='" + name + '\'' +
                ", companyname='" + companyname + '\'' +
                ", measurement=" + measurement +
                ", weighing=" + weighing +
                ", catMap=" + catMap +
                ", images=" + images +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (itemid != item.itemid) return false;
        if (!name.equals(item.name)) return false;
        return companyname.equals(item.companyname);
    }

    @Override
    public int hashCode() {
        int result = itemid;
        result = 31 * result + name.hashCode();
        result = 31 * result + companyname.hashCode();
        return result;
    }
}
