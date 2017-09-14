package com.flpkrt.main;

import com.flpkrt.entity2.NewAddress;
import com.flpkrt.entity2.NewUser;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Main5 {
    public static void main(String args[]){
        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        NewAddress ad=new NewAddress();
        ad.setCity("bengaluru").setHouseNumber("401B").setState("karnataka").setStreetName("bakasur");

        NewUser u=new NewUser();
        u.setAddress(ad).setFirstName("aditya").setLastName("singh");
        ad.setUser(u);

        em.getTransaction().begin();
        em.persist(u);
        em.flush();
        em.getTransaction().commit();
    }
    public static void oneToOneSamekey(){
        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
       /* NewAddress ad=new NewAddress();
        ad.setCity("bengaluru").setHouseNumber("401B").setState("karnataka").setStreetName("bakasur");
        em.getTransaction().begin();
        em.persist(ad);
        em.flush();
        em.getTransaction().commit();

        NewUser u=new NewUser();
        u.setId(ad.getId()).setAddress(ad).setFirstName("aditya").setLastName("singh");

        em.getTransaction().begin();
        em.persist(u);
        em.flush();
        em.getTransaction().commit();*/

        NewUser u=em.find(NewUser.class,207);
        System.out.println(u);

    }
}
