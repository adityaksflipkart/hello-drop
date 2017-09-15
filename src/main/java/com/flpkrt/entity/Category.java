package com.flpkrt.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public Category setType(String type) {
        this.type = type;
        return this;
    }

    @OneToMany(mappedBy = "category")
    private Set<ItemCategoryMap> itemMap=new HashSet<ItemCategoryMap>();

    public Set<ItemCategoryMap> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Set<ItemCategoryMap> itemMap) {
        this.itemMap = itemMap;
    }
    /*    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "itemcategorymap",joinColumns = @JoinColumn(name = "categoryid"),inverseJoinColumns = @JoinColumn(name="itemid"))
    private Set<Item> items=new HashSet<Item>();

    public Set<Item> getItems() {
        return items;
    }

    public Category setItems(Set<Item> items) {
        this.items = items;
        return this;
    }*/

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", itemMap=" + itemMap +
                '}';
    }
}
