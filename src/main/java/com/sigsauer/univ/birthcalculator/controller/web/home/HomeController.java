package com.sigsauer.univ.birthcalculator.controller.web.home;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/")
public class HomeController {

    @GET
    @Path("")
    public Response home() {
        return Response.ok("Hello! This is start page :)").build();
    }
}
