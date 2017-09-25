package com.flpkrt.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ItemCategoryMap {

    @EmbeddedId
    private Id id=new Id();

    @NotNull
    private String itemName;
    @NotNull
    private Date createdon=new Date();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itemid",updatable = false,insertable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryid",updatable = false,insertable = false)
    private Category category;


    public ItemCategoryMap(String itemName, Item item, Category category) {
        this.itemName = itemName;
        this.item = item;
        this.category = category;
        this.id.categoryid=category.getId();
        this.id.itemid=item.getItemid();

        category.getItemMap().add(this);
    }

    public ItemCategoryMap() {
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getCreatedon() {
        return createdon;
    }

    public void setCreatedon(Date createdon) {
        this.createdon = createdon;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Embeddable
    public static class Id implements Serializable{
        private int itemid;
        private int categoryid;

        public Id(int itemid, int categoryid) {
            this.itemid = itemid;
            this.categoryid = categoryid;
        }

        public Id() {
        }

        public int getItemid() {
            return itemid;
        }

        public void setItemid(int itemid) {
            this.itemid = itemid;
        }

        public int getCategoryid() {
            return categoryid;
        }

        public void setCategoryid(int categoryid) {
            this.categoryid = categoryid;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Id id = (Id) o;

            if (itemid != id.itemid) return false;
            return categoryid == id.categoryid;
        }

        @Override
        public int hashCode() {
            int result = itemid;
            result = 31 * result + categoryid;
            return result;
        }

        @Override
        public String toString() {
            return "Id{" +
                    "itemid=" + itemid +
                    ", categoryid=" + categoryid +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ItemCategoryMap{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", createdon=" + createdon +
                ", item=" + item +
                ", category=" + category +
                '}';
    }
}
