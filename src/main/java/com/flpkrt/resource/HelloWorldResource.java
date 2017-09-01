package com.flpkrt.resource;

import com.codahale.metrics.annotation.Timed;
import com.flpkrt.app.Saying;
import com.flpkrt.entity.Address;
import com.flpkrt.service.HelloDBServices;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource  {

    private AtomicLong counter;
    private HelloDBServices service;
    @Inject
    public HelloWorldResource(HelloDBServices service) {
        this.service=service;
        this.counter=new AtomicLong();
    }
    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") String name){
        if(!name.equals("aditya")){
            throw new IllegalArgumentException();
        }
        Address ad=new Address();
        ad.setCity("banglore").setCountry("india").setState("karnataka").setStreet("gree glen").setPincode("123123");
        service.saveObject(ad);
        return new Saying(counter.incrementAndGet(),"hello "+name);
    }
}
