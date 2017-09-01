package com.flpkrt.conf;

import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import io.dropwizard.jersey.errors.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;


public class MyExceptionMapper implements ExceptionMapper<IllegalArgumentException>{
    private final Meter exception;
    public MyExceptionMapper(MetricRegistry met){
        exception=met.meter(MetricRegistry.name(getClass(),"exception"));
    }

    @Override
    public Response toResponse(IllegalArgumentException e) {
        exception.mark();
        return Response.status(Response.Status.BAD_REQUEST)
                .header("X-YOU-SILLY", "true")
                .type(MediaType.APPLICATION_JSON_TYPE)
                .entity(new ErrorMessage(Response.Status.BAD_REQUEST.getStatusCode(),
                        "You passed an illegal argument!"))
                .build();
    }
}
