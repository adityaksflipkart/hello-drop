package com.flpkrt.main;

import com.flpkrt.entity.Image;
import com.flpkrt.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main4 {
    public static void main(String args[]) {

        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        Item item=new Item();
        item.setCompanyname("ms");
        item.setName("asdad");

        Image image1=new Image();
        image1.setBredth(12213).setImagename("a.jpeg").setLength(122);


        Image image2=new Image();
        image2.setBredth(12213).setImagename("b.jpeg").setLength(1233);


        Image image3=new Image();
        image3.setBredth(12213).setImagename("c.jpeg").setLength(1211);


        Image image4=new Image();
        image4.setBredth(12213).setImagename("d.jpeg").setLength(1200);


        item.getImages().put("a",image1);
        item.getImages().put("b",image2);
        item.getImages().put("c",image3);
        item.getImages().put("d",image4);
        em.getTransaction().begin();
        em.persist(item);
        em.flush();
        em.getTransaction().commit();
   /*     Item item=em.find(Item.class,187);


        for (Image image:item.getImages()) {
            System.out.println(image);
        }*/


    }

}
