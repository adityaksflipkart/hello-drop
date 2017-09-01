package com.flpkrt.app;

import com.codahale.metrics.MetricRegistry;
import com.flpkrt.conf.HelloWorldConfiguration;
import com.flpkrt.conf.MyCommandLine;
import com.flpkrt.conf.MyExceptionMapper;
import com.flpkrt.filter.MyHeaderFilter;
import com.flpkrt.guice.HelloWorldGuiceModule;
import com.flpkrt.test.TemplateHealthCheck;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {

    public static void main(String args[]) throws Exception {
        new HelloWorldApplication().run(args);

    }
    @Override
    public String getName(){
        return "hello-world";
    }

    @Override
    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {
            /*final HelloWorldResource resource=new HelloWorldResource(helloWorldConfiguration.getTemplate()
                ,helloWorldConfiguration.getDefaultName());
environment.jersey().register(resource);
*/
            final TemplateHealthCheck check=new TemplateHealthCheck("");

            environment.healthChecks().register("template",check);



            environment.jersey().register(new MyExceptionMapper(environment.metrics()));

            FilterRegistration.Dynamic flt=environment.servlets().addFilter("crossOriginFilter", CrossOriginFilter.class);

            flt.setInitParameter("allowedMethods", "GET,PUT,POST,DELETE,OPTIONS,HEAD");
            flt.setInitParameter("allowedOrigins", "*"); // allowed origins comma separated
            flt.setInitParameter("allowedHeaders", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin");
            flt.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class),true,"/*");

            environment.jersey().register(MyHeaderFilter.class);

    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        bootstrap.addCommand(new MyCommandLine());
        MetricRegistry metricRegistry = bootstrap.getMetricRegistry();
        JpaPersistModule jpaPersistModule=new JpaPersistModule("hello-world");

        GuiceBundle<HelloWorldConfiguration> guiceBundle=GuiceBundle.<HelloWorldConfiguration>newBuilder()
                                        .addModule(new HelloWorldGuiceModule())
                                        .addModule(new JpaPersistModule("hello-world"))
                                        //.enableAutoConfig("com.flpkrt")
                                        .setConfigClass(HelloWorldConfiguration.class).build();
        bootstrap.addBundle(guiceBundle);
        guiceBundle.getInjector().getInstance(PersistService.class).start();

    }
}
