package com.flpkrt.main;

import com.flpkrt.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.*;

public class Main3 {

    public static void main(String args[]){
        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        CreditCardDetails c=new CreditCardDetails();
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

        UserAddress uad=new UserAddress();
        uad.setStreet("green glen");
        uad.setPincode(new ZipCode("12345"));
        uad.setCountry("india");
        uad.setCity("bengaluru");
        uad.setState("karnataka");

        u.setAddress(uad);
        u.setDeliveryAddress(uad);

        u.setAmount(new MonetoryAmount(new BigDecimal("123123"), Currency.getInstance(Locale.US)));
        em.getTransaction().begin();
        em.persist(u);
         em.persist(c);
         em.persist(b);
        em.flush();
        em.getTransaction().commit();


        List<User> list=em.createQuery("select u from User u").getResultList();
        for (User u1:list) {
            System.out.println(u1);
        }

         u=em.find(User.class,138);
        System.out.println(u);
    }
    public static void manyToOneMultiPlicity(){
        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        CreditCardDetails c=new CreditCardDetails();
        c.setFirstName("aditya");
        c.setLastName("singh");
        c.setCardNumber("12312312312312321");
        c.setCvv("154");
        c.setExpiryDate(new Date());

        User u=new User();
        u.setFirstname("aditya");
        u.setLastname("singh");

       // u.setBillingDetail(c);
        UserAddress uad=new UserAddress();
        uad.setStreet("green glen");
        uad.setPincode(new ZipCode("12345"));
        uad.setCountry("india");
        uad.setCity("bengaluru");
        uad.setState("karnataka");

        u.setAddress(uad);
        u.setDeliveryAddress(uad);
        u.setAmount(new MonetoryAmount(new BigDecimal("123123"), Currency.getInstance(Locale.US)));
        em.getTransaction().begin();
        em.persist(u);
        em.persist(c);
        em.flush();
        em.getTransaction().commit();


        List<User> list=em.createQuery("select u from User u").getResultList();
        for (User u1:list) {
            System.out.println(u1);
        }

        u=em.find(User.class,103);
        System.out.println(u);
    }
    public static void embededInheritance(){
        EntityManager  em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        Measurement m=new Measurement();
        m.setBreadth(12);
        m.setLength(2323);
        m.setHeight(123);
        m.setName("meter");
        m.setSymbol("M");

        Weight w=new Weight();
        w.setWeight(1223);
        w.setName("kilograms");
        w.setSymbol("KG");

        Item i=new Item();
        i.setMeasurement(m);
        i.setWeighing(w);
        i.setName("Bed");
        i.setCompanyname("sleepware");

        em.getTransaction().begin();
        em.persist(i);
        em.getTransaction().commit();

        List<Item> it=em.createQuery("select i from Item  i").getResultList();
        for (Item t:it) {
            System.out.println(t);
        }
        em.close();
    }
}
