package com.sigsauer.univ.birthcalculator.controller.web.birth;

import com.sigsauer.univ.birthcalculator.model.User;
import com.sigsauer.univ.birthcalculator.service.birth.BirthService;
import com.sigsauer.univ.birthcalculator.service.birth.bean.BirthTimer;
import com.sigsauer.univ.birthcalculator.service.shared.ServiceFactory;
import com.sigsauer.univ.birthcalculator.service.user.UserService;
import com.sigsauer.univ.birthcalculator.service.user.UserServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/birth")
public class BirthController {

    private final BirthService birthService = ServiceFactory.getBirthService();

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response calculateBirth(@PathParam("id") Long id) {
        BirthTimer bt = birthService.calculateTimeUntilBirthday(id, new Date());
        return Response.ok(bt).build();
    }

}
