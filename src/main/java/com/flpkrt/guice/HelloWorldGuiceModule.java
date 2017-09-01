package com.flpkrt.guice;

import com.flpkrt.resource.HelloWorldResource;
import com.flpkrt.service.HelloDBServices;
import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;

public class HelloWorldGuiceModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(HelloDBServices.class).in(Singleton.class);
        bind(HelloWorldResource.class).in(Singleton.class);
    }
}
