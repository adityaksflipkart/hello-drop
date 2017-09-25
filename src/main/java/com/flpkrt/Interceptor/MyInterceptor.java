package com.flpkrt.Interceptor;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyInterceptor extends EmptyInterceptor{

    private EntityManager em;
    private String userName;
    private int userId;
    private Set<Auditable> commits=new HashSet<Auditable>();

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if(entity instanceof Auditable)
        commits.add((Auditable)entity);
        return false;
    }

    @Override
    public void postFlush(Iterator entities) {
        //Session s=em.sessionWithOptions().transactionContext().connection().openSession();
        try {
            for (Auditable a : commits) {

                em.persist(new AuditLog().setEntityId(a.getId()).setAuditDate(new Date()).setClassName(a.getClass().getSimpleName()).setMessage("this is a commit").setUserName(getUserName()).setUserId(getUserId()));


            }
        }catch(Exception e){
            System.out.println(e);
        }finally {
            commits.clear();
        }


    }
    public void setEm(EntityManager em) {
        this.em = em;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
