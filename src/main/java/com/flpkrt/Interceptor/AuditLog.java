package com.flpkrt.Interceptor;

import javax.persistence.*;
import java.util.Date;

@Entity
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String userName;
    private int userId;
    @Temporal(TemporalType.DATE)
    private Date auditDate;
    private String className;
    private String message;
    private int entityId;

    public int getId() {
        return id;
    }

    public AuditLog setId(int id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public AuditLog setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public AuditLog setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public AuditLog setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
        return this;
    }

    public String getClassName() {
        return className;
    }

    public AuditLog setClassName(String className) {
        this.className = className;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public AuditLog setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getEntityId() {
        return entityId;
    }

    public AuditLog setEntityId(int entityId) {
        this.entityId = entityId;
        return this;
    }

    @Override
    public String toString() {
        return "AuditLog{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userId=" + userId +
                ", auditDate='" + auditDate + '\'' +
                ", className='" + className + '\'' +
                ", message='" + message + '\'' +
                ", entityId=" + entityId +
                '}';
    }

}
