package com.flpkrt.main;

import com.flpkrt.entity.Category;
import com.flpkrt.entity.Item;
import com.flpkrt.entity.ItemCategoryMap;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.swing.text.StyledEditorKit;

public class Main6 {

    public static void main(String args[]){
        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
/*        em.getTransaction().begin();
        Category cat1=new Category();
        cat1.setType("categoty 2");

        Category cat2=new Category();
        cat2.setType("categoty 1");

        em.persist(cat1);
        em.persist(cat2);

        Item item1=new Item();
        item1.setName("new item23");
        item1.setCompanyname("ms3424");


        Item item2=new Item();
        item2.setName("new item324");
        item2.setCompanyname("ms213");

        em.persist(item1);
        em.persist(item2);

        ItemCategoryMap mp1=new ItemCategoryMap("newItem1",item1,cat1);
        ItemCategoryMap mp2=new ItemCategoryMap("newItem2",item2,cat2);
        ItemCategoryMap mp3=new ItemCategoryMap("newItem3",item2,cat1);
        ItemCategoryMap mp4=new ItemCategoryMap("newItem4",item1,cat2);
        em.persist(mp1);
        em.persist(mp2);
        em.persist(mp3);
        em.persist(mp4);
        em.getTransaction().commit();*/

        Item item=em.find(Item.class,272);
        System.out.println(item);

        for (ItemCategoryMap mp:item.getCatMap()) {
            System.out.println(mp);
        }
    }
}
