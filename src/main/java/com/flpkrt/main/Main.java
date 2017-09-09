package com.flpkrt.main;

import com.flpkrt.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Main {
    public static void main(String args[]) throws SQLException, ClassNotFoundException {

    }

    public static void customConvertors(){
        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        User u=new User();
        u.setFirstname("aditya");
        u.setLastname("singh");


        UserAddress uad=new UserAddress();
        uad.setStreet("green glen");
        uad.setPincode(new ZipCode("12345"));

        u.setAddress(uad);
        u.setDeliveryAddress(uad);
        u.setAmount(new MonetoryAmount(new BigDecimal("123123"), Currency.getInstance(Locale.US)));
        em.getTransaction().begin();
        em.persist(u);
        em.flush();
        em.getTransaction().commit();


        List<User> list=em.createQuery("select u from User u").getResultList();
        for (User u1:list) {
            System.out.println(u1);
        }

    }

    public static void embededEntity(){
        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        User u=new User();
        u.setFirstname("aditya");
        u.setLastname("singh");

        UserAddress uad=new UserAddress();
        uad.setStreet("green glen");

        u.setAddress(uad);
        u.setDeliveryAddress(uad);

        em.getTransaction().begin();
        em.persist(u);
        em.flush();
        em.getTransaction().commit();


        List<User> list=em.createQuery("select u from User u").getResultList();
        for (User u1:list) {
            System.out.println(u1);
        }
    }
    public static void subSelect(){
        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        SubAddress subAd=em.find(SubAddress.class,"2");
        System.out.println(subAd);
    }
    public static void queryExample(){
        EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
        CriteriaBuilder cb=em.getCriteriaBuilder();

        CriteriaQuery<Address> query= cb.createQuery(Address.class);
        Root<Address> from=query.from(Address.class);
        query.select(from);
        Path<String> city=from.get("city");
        query.where(cb.like(city,cb.parameter(String.class,"pattern")));

        List<Address> list=em.createQuery(query).setParameter("pattern","%banglore%").getResultList();

        for (Address ad:list) {
            System.out.println(ad);
        }
    }
    public static void metaModel(){
        Metamodel metamodel=Persistence.createEntityManagerFactory("hello-world").getMetamodel();
        for (EntityType entity:metamodel.getEntities()) {
            System.out.println(entity.getName());
            System.out.println(entity.getAttributes());
            System.out.println(entity.getIdType());
            System.out.println(entity.getJavaType());
            System.out.println(entity.getBindableType());
        }
    }
    public static  void voildations(){
        Address ad=new Address();
        ad.setCity("hyderabad").setCountry("india").setState("Telangana").setStreet("dharitri nilayam").setPincode("500084");
        Validator validator=Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Address>> voilations=validator.validate(ad);
        for (ConstraintViolation<Address> address:voilations) {
            System.out.println(address.getMessage());
        }
  /*     EntityManager em=Persistence.createEntityManagerFactory("hello-world").createEntityManager();
       em.getTransaction().begin();
       em.persist(ad);
       em.flush();
       em.getTransaction().commit();
        jdbcRead();*/
    }
    public static void wholeBootUpProcess(){

        StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();

        builder.applySetting("hibernate.use_sql_comments",true);
        builder.applySetting("hibernate.hbm2ddl.auto","validate");
        builder.applySetting("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        builder.applySetting("hibernate.format_sql",true);
        builder.applySetting("hibernate.show_sql",true);
        builder.applySetting("connection.driver_class","com.mysql.jdbc.Driver");
        builder.applySetting("connection.url","jdbc:mysql://localhost:3306/test");
        builder.applySetting("connection.username","root");
        builder.applySetting("connection.password","aditya123");

        ServiceRegistry registry=builder.build();

        MetadataSources metadataSources=new MetadataSources(registry);
        metadataSources.addAnnotatedClass(Address.class);


        MetadataBuilder metadataBuilder=metadataSources.getMetadataBuilder();

        SessionFactory fac=metadataBuilder.build().buildSessionFactory();

        EntityManager em= fac.createEntityManager();

        List<Address> address=em.createQuery("select m from Address m").getResultList();
        for (Address a:address) {
            System.out.println(a);
        }
        em.close();
    }
    public static void usingCFGFile(){
        SessionFactory fac = new MetadataSources(new StandardServiceRegistryBuilder().configure("META-INF/hibernate.cfg.xml").build()).buildMetadata().buildSessionFactory();
        EntityManager em=fac.createEntityManager();

        List<Address> address=em.createQuery("select m from Address m").getResultList();
        for (Address a:address) {
            System.out.println(a);
        }
        em.close();
    }
    public static void jdbcRead() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","aditya123");
        Statement stmt=con.createStatement();
        stmt.execute("select * from Address;");
        ResultSet result=stmt.getResultSet();
        while(result.next()){
            System.out.println(result.getObject(1)+" "+result.getObject(2)+" "
                    +result.getObject(3)+" "+result.getObject(4));
        }
    }
    public static void jpaExample(){
        Address ad=new Address();
        ad.setCity("hyderabad").setCountry("india").setState("Telangana").setStreet("dharitri nilayam").setPincode("500084");
        EntityManagerFactory fac=Persistence.createEntityManagerFactory("hello-world");

        EntityManager em=fac.createEntityManager();
        em.getTransaction().begin();

        em.persist(ad);

        em.flush();
        em.getTransaction().commit();
         //em.getTransaction().begin();
        List<Address> address=em.createQuery("select m from Address m").getResultList();
        ///em.getTransaction().commit();
        for (Address a:address) {
            System.out.println(a);
        }


        em.close();
    }
}
