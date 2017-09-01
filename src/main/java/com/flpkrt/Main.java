package com.flpkrt;

import com.flpkrt.entity.Address;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.*;
import java.util.List;


public class Main {
    public static void main(String args[]) throws SQLException, ClassNotFoundException {

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
        stmt.execute("select * from address;");
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
        // em.getTransaction().begin();
        List<Address> address=em.createQuery("select m from Address m").getResultList();
        // em.getTransaction().commit();
        for (Address a:address) {
            System.out.println(a);
            a.setState("karnataka");
        }

        em.close();
    }
}
