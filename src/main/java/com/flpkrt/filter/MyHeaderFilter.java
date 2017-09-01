package com.flpkrt.filter;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jetty.http.HttpHeader;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class MyHeaderFilter implements ContainerRequestFilter{


    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if(StringUtils.isBlank(requestContext.getHeaderString(HttpHeader.DATE.name()))){
            Exception cause=new IllegalArgumentException("Date header filed missing");
            throw new WebApplicationException(cause, Response.Status.BAD_REQUEST);
        }
    }
}
