package com.flpkrt.entity2;


import javax.persistence.*;
@Table(indexes = @Index(name = "",columnList = "emailid"))
@Entity
public class TestEntity {

    private int id;

    @Version
    private int version;

    private String emailId;
    //@Column(columnDefinition = "varchar(15) not null unique"+"check(not substring(lower(USERNAME), 0,5) = 'admin')")
    private String userName;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", version=" + version +
                ", emailId='" + emailId + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
