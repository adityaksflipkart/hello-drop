package com.flpkrt.main;

import com.flpkrt.entity.Bid;
import com.flpkrt.entity.Image;
import com.flpkrt.entity.ImageName;
import com.flpkrt.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Date;

public class Main4 {
    public static void main(String args[]) {
       EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
 /*        Item item=new Item();
        item.setCompanyname("ms");
        item.setName("asdad");

        Bid b1=new Bid();
        b1.setAmount(213);
        b1.setBidDate(new Date());
        b1.setItem(item);


        Bid b2=new Bid();
        b2.setAmount(21233);
        b2.setBidDate(new Date());
        b2.setItem(item);

        Bid b3=new Bid();
        b3.setAmount(2123323);
        b3.setBidDate(new Date());
        b3.setItem(item);

        item.getBids().add(b1);
        item.getBids().add(b2);
        item.getBids().add(b3);

        em.getTransaction().begin();
        em.persist(item);
        em.persist(b1);
        em.flush();
        em.getTransaction().commit();*/


        em.getTransaction().begin();
        Bid b=em.find(Bid.class,222);
        System.out.println(b);
        em.getTransaction().commit();
        em.close();
    }
    private void manytoone(){
        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        Item item=new Item();
        item.setCompanyname("ms");
        item.setName("asdad");

        Bid b=new Bid();
        b.setAmount(213);
        b.setBidDate(new Date());
        b.setItem(item);
        em.getTransaction().begin();
        em.persist(item);
        em.persist(b);
        em.flush();
            em.getTransaction().commit();
    }
    private static void entityCollection(){

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


        item.getImages().put(new ImageName().setExt("jpg").setName("water"),image1);
        item.getImages().put(new ImageName().setName("fire").setExt("jpeg"),image2);
        item.getImages().put(new ImageName().setExt("mpg").setName("earth"),image3);
        item.getImages().put(new ImageName().setName("sky").setExt("mpeg"),image4);
        em.getTransaction().begin();
        em.persist(item);
        em.flush();
        em.getTransaction().commit();

    }
}
