package com.flpkrt.entity2;


import com.flpkrt.Interceptor.Auditable;
import com.flpkrt.main.PersistEntityListner;

import javax.persistence.*;
@Table(indexes = @Index(name = "",columnList = "emailid"))
@Entity
@EntityListeners({PersistEntityListner.class,})
public class TestEntity implements Auditable{

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestEntity that = (TestEntity) o;

        if (id != that.id) return false;
        if (version != that.version) return false;
        if (!emailId.equals(that.emailId)) return false;
        return userName.equals(that.userName);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + version;
        result = 31 * result + emailId.hashCode();
        result = 31 * result + userName.hashCode();
        return result;
    }
}
