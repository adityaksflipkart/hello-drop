package com.flpkrt.main;

import com.flpkrt.entity.Image;
import com.flpkrt.entity.Item;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Comparator;

public class Main4 {
    public static void main(String args[]) {

        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
     /*   Item item=new Item();
        item.setCompanyname("ms");
        item.setName("asdad");

        Image image1=new Image();
        image1.setBredth(12213).setFilename("a.txt").setImagen("a.jpeg").setLength(122);


        Image image2=new Image();
        image2.setBredth(12213).setFilename("b.txt").setImagen("b.jpeg").setLength(1233);


        Image image3=new Image();
        image3.setBredth(12213).setFilename("c.txt").setImagen("c.jpeg").setLength(1211);


        Image image4=new Image();
        image4.setBredth(12213).setFilename("d.txt").setImagen("d.jpeg").setLength(1200);


        item.getImages().add(image1);
        item.getImages().add(image2);
        item.getImages().add(image3);
        item.getImages().add(image4);
        em.getTransaction().begin();
        em.persist(item);
        em.flush();
        em.getTransaction().commit();*/
        Item item=em.find(Item.class,180);


        for (Image image:item.getImages()) {
            System.out.println(image);
        }


    }
    public static class ReverseComparator implements Comparator<String>{


        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }

}
