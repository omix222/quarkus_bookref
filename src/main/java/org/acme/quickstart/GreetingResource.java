package org.acme.quickstart;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(
            @Context UriInfo uriInfo,
            @QueryParam("order") Order order,
            @NotBlank @HeaderParam("authorization") String authorization
            ) {

        return String.format("URI: %s - Order %s - Authorization: %s",
                uriInfo.getAbsolutePath(), order, authorization);
    }
}