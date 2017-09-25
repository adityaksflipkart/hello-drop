package com.flpkrt.main;

import javax.persistence.*;

public class PersistEntityListner {

    @PostLoad
    public void postLoad(Object entityInstance){
        System.out.println("called during postLoad for "+entityInstance);
    }
    @PostPersist
    public void postPersist(Object entityInstance){
        System.out.println("called during postPersist for "+entityInstance);
    }
    @PrePersist
    public void prePersist(Object entityInstance){
        System.out.println("called during prePersist for "+entityInstance);
    }
    @PostRemove
    public void postRemove(Object entityInstance){
        System.out.println("called during postRemove for "+entityInstance);
    }
    @PreRemove
    public void preRemove(Object entityInstance){
        System.out.println("called during preRemove for "+entityInstance);
    }
    @PostUpdate
    public void postUpdate(Object entityInstance){
        System.out.println("called during postUpdate for "+entityInstance);
    }
    @PreUpdate
    public void preUpdate(Object entityInstance){
        System.out.println("called during preUpdate for "+entityInstance);
    }
}
