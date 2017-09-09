package com.flpkrt.main;

import com.flpkrt.entity.BankDetails;
import com.flpkrt.entity.BillingDetail;
import com.flpkrt.entity.CreditCardDetails;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class Main2 {
    public static void main(String args[]){
        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        BankDetails b=new BankDetails();
        b.setFirstName("aditya");
        b.setLastName("singh");
        b.setAccountNumber("1231231231231");
        b.setAccountType("saving");
        b.setIifcCode("CITI000005");
        b.setBankName("citi");

        CreditCardDetails c=new CreditCardDetails();
        c.setFirstName("aditya");
        c.setLastName("singh");
        c.setCardNumber("12312312312312321");
        c.setCvv("154");
        c.setExpiryDate(new Date());


        em.getTransaction().begin();
        em.persist(b);
        em.persist(c);
        em.flush();
        em.getTransaction().commit();

        List<BankDetails> l=em.createQuery("select b from BankDetails b", BankDetails.class).getResultList();
        for (BankDetails d:l) {
            System.out.println(d);
        }


        List<CreditCardDetails> l1=em.createQuery("select b from CreditCardDetails b", CreditCardDetails.class).getResultList();
        for (CreditCardDetails d:l1) {
            System.out.println(d);
        }

        BillingDetail l2=em.find(BillingDetail.class,69);
        /*for (CreditCardDetails d:l2) {
            System.out.println(d);
        }*/
        System.out.println(l2);

    }
    private static void singleTableIheritence(){
        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        BankDetails b=new BankDetails();
        b.setFirstName("aditya");
        b.setLastName("singh");
        b.setAccountNumber("1231231231231");
        b.setAccountType("saving");
        b.setIifcCode("CITI000005");
        b.setBankName("citi");

        CreditCardDetails c=new CreditCardDetails();
        c.setFirstName("aditya");
        c.setLastName("singh");
        c.setCardNumber("12312312312312321");
        c.setCvv("154");
        c.setExpiryDate(new Date());


        em.getTransaction().begin();
        em.persist(b);
        em.persist(c);
        em.flush();
        em.getTransaction().commit();

        List<BankDetails> l=em.createQuery("select b from bankdetails b", BankDetails.class).getResultList();
        for (BankDetails d:l) {
            System.out.println(d);
        }


        List<CreditCardDetails> l1=em.createQuery("select b from creditcarddetails b", CreditCardDetails.class).getResultList();
        for (CreditCardDetails d:l1) {
            System.out.println(d);
        }
    }
    private static void perInheritanceTable(){

        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        BankDetails b=new BankDetails();
        b.setFirstName("aditya");
        b.setLastName("singh");
        b.setAccountNumber("1231231231231");
        b.setAccountType("saving");
        b.setIifcCode("154");
        b.setBankName("citi");
        em.getTransaction().begin();
        em.persist(b);
        em.flush();
        em.getTransaction().commit();
        List<BankDetails> l=em.createQuery("select b from BankDetails b").getResultList();
        for (BankDetails d:l) {
            System.out.println(d);
        }

        em.createQuery("select b from BillingDetail b").getResultList();


        em.close();
    }
}
