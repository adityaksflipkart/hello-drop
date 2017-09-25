package com.flpkrt.main;

import com.flpkrt.Interceptor.MyInterceptor;
import com.flpkrt.entity.*;
import com.flpkrt.entity2.TestEntity;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.jpa.AvailableSettings;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.*;


public class Main7 {

    public static void main(String args[]) {

        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        AuditReader au= AuditReaderFactory.get(em);
        List<Number> revisions=au.getRevisions(TestEntity.class,382);

        for (Number n:revisions) {
            System.out.println(n);
        }

        TestEntity t=au.find(TestEntity.class,382,3);

        em.getTransaction().begin();
        em.unwrap(Session.class).replicate(t, ReplicationMode.OVERWRITE);
        em.flush();
        em.getTransaction().commit();


        TestEntity t1=em.find(TestEntity.class,382);
        System.out.println(t1);

    }

    private static void interceptors(){
        Map<String,String> properties=new HashMap<String,String>();
        properties.put(AvailableSettings.SESSION_INTERCEPTOR, MyInterceptor.class.getName());
        EntityManager em=Persistence.createEntityManagerFactory("hello-world",properties).createEntityManager();

        em.getTransaction().begin();


        MyInterceptor interceptor=(MyInterceptor)((SessionImplementor)em.unwrap(Session.class)).getInterceptor();
        interceptor.setEm(em);
        interceptor.setUserId(12);
        interceptor.setUserName("aditya");

        TestEntity t=new TestEntity();
        t.setEmailId("asafadfdsfsdf3487437834783478sdfsdfsfsdfsdfsdfsdsdf");
        t.setUserName("asfsdfsdfsdf333333333");
        em.persist(t);
        em.flush();
        em.getTransaction().commit();
    }


    private static void mergeCascade(){
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

        c.setUser(u);
        b.setUser(u);

        UserAddress uad1=new UserAddress();
        uad1.setStreet("green glen");
        uad1.setPincode(new ZipCode("12345"));
        uad1.setCountry("india");
        uad1.setCity("bengaluru");
        uad1.setState("karnataka");

        UserAddress uad2=new UserAddress();
        uad2.setStreet("green glen");
        uad2.setPincode(new ZipCode("12345"));
        uad2.setCountry("india");
        uad2.setCity("bengaluru");
        uad2.setState("karnataka");
        uad2.getDeliveries().add(new Delivery().setDeliveryName("new delivery"));

        u.setAddress(uad1);
        u.setDeliveryAddress(uad2);

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

     /*   u=em.find(User.class,138);
        System.out.println(u);
*/
    }
}