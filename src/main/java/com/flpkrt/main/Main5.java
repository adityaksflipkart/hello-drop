package com.flpkrt.main;

import com.flpkrt.entity.*;
import com.flpkrt.entity2.NewAddress;
import com.flpkrt.entity2.NewUser;
import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.*;

public class Main5 {
    public static void main(String args[]){
        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
 /*       CreditCardDetails c=new CreditCardDetails();
        c.setFirstName("aditya");
        c.setLastName("singh");
        c.setCardNumber("12312312312312321");
        c.setCvv("154");
        c.setExpiryDate(new Date());

        BankDetails b=new BankDetails();
        b.setFirstName("aditya");
        b.setLastName("singh");
        b.setAccountNumber("1231231231231");
        b.setAccountType("saving");
        b.setIifcCode("CITI000005");
        b.setBankName("citi");


        User u=new User();
        u.setFirstname("aditya");
        u.setLastname("singh");

        Set<BillingDetail> detail=new HashSet<BillingDetail>();
        detail.add(c);
        detail.add(b);
        u.setBillingDetail(detail);

        c.setUser(u);
        b.setUser(u);

        UserAddress uad=new UserAddress();
        uad.setStreet("green glen");
        uad.setPincode(new ZipCode("12345"));
        uad.setCountry("india");
        uad.setCity("bengaluru");
        uad.setState("karnataka");


        UserAddress uad1=new UserAddress();
        uad1.setStreet("green glen");
        uad1.setPincode(new ZipCode("12345"));
        uad1.setCountry("india");
        uad1.setCity("bengaluru");
        uad1.setState("karnataka");

        u.setAddress(uad);
        u.setDeliveryAddress(uad1);

        Delivery d=new Delivery();
        d.setDeliveryName("sdasafafda");
        Delivery d1=new Delivery();
        d1.setDeliveryName("sdasafafda");

        u.getDeliveryAddress().getDeliveries().add(d);
        u.getAddress().getDeliveries().add(d1);

        u.setAmount(new MonetoryAmount(new BigDecimal("123123"), Currency.getInstance(Locale.US)));
        em.getTransaction().begin();
        em.persist(u);
        em.flush();
        em.getTransaction().commit();*/

        User u=em.find(User.class,245);
        System.out.println(u);

    }
    public static void oneToOneTableMapping(){
        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        NewAddress ad=new NewAddress();
        ad.setCity("bengaluru").setHouseNumber("401B").setState("karnataka").setStreetName("bakasur");

        NewUser u=new NewUser();
        u.setAddress(ad).setFirstName("aditya").setLastName("singh");

        em.getTransaction().begin();
        em.persist(u);
        em.flush();
        em.getTransaction().commit();

      /*  NewUser u=em.find(NewUser.class,207);
        System.out.println(u);*/
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
