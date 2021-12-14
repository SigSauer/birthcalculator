package com.sigsauer.univ.birthcalculator.controller.api.users;

import com.sigsauer.univ.birthcalculator.controller.api.users.bean.CreateUserRequest;
import com.sigsauer.univ.birthcalculator.controller.api.users.bean.UserResponse;
import com.sigsauer.univ.birthcalculator.service.user.UserService;
import com.sigsauer.univ.birthcalculator.service.user.UserServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Path("users")
public class UserController {

    private final UserService userService = new UserServiceImpl();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        List<UserResponse> users = userService.getAllUsers().stream().map(UserResponse::new).collect(Collectors.toList());
        return Response.ok(users).build();
    }

    @GET()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOneUser(@PathParam("id") Long id) {
        return Response.ok(new UserResponse(userService.getUserById(id))).build();
    }

    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(CreateUserRequest userRequest) {
        return Response.ok(new UserResponse(userService.createUser(userRequest.toUser()))).build();
    }

    @PUT()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") Long id,  CreateUserRequest userRequest) {
        return Response.ok(new UserResponse(userService.updateUser(id, userRequest.toUser()))).build();
    }

    @DELETE()
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("id") Long id) {
        userService.deleteUser(id);
        return Response.ok().build();
    }
}
