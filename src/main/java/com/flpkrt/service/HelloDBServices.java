package com.flpkrt.service;

import com.google.inject.persist.Transactional;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.persistence.EntityManager;

public class HelloDBServices {

    private Provider<EntityManager> entityManager;
    @Inject
    public HelloDBServices(Provider<EntityManager> entityManager) {
        this.entityManager=entityManager;
    }

    @Transactional
    public void saveObject(Object entity){
        EntityManager em=entityManager.get();
       // em.getTransaction().begin();
        em.persist(entity);
        //em.getTransaction().commit();
        em.flush();
        //em.close();
    }
}
