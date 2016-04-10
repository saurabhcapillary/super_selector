package com.saurabh.superselectorbackend.controller;

import com.saurabh.superselectorbackend.models.Users;
import com.saurabh.superselectorbackend.models.response.MatchPointsResponse;
import com.saurabh.superselectorbackend.models.response.UsersPointsMapping;
import com.saurabh.superselectorbackend.models.response.UsersResponse;
import com.saurabh.superselectorbackend.service.MatchPointsFacade;
import com.saurabh.superselectorbackend.service.UsersGroupFacade;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saurabh
 */

@Path("/user/")
@Controller
public class UserResource {
    
    @Inject
    private UsersGroupFacade usersGroupFacade;

    @Inject
    private MatchPointsFacade matchPointsFacade;

    @GET
    @Path("points/{id}")
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getCountry(@PathParam("id")  Long userId, @QueryParam("match_id") Long matchId){
        MatchPointsResponse response=matchPointsFacade.getUserPoints(userId,matchId);
        return Response.status(200).entity(response).build();

    }

    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    @Path("points")
    public Response getAllUsersPoints(@QueryParam("match_id") long matchId ){
        UsersPointsMapping response = matchPointsFacade.getAllUserPoints(matchId);
        return Response.status(200).entity(response).build();
    }

    
    @Path("/login/")
    @POST
    @Consumes( { MediaType.APPLICATION_JSON })
    @Produces( { MediaType.APPLICATION_JSON })
    public Response Login(@RequestBody Users users){
        UsersResponse response =
                usersGroupFacade.login(users);
        return Response.status(200).entity(response).build();
    }
    
    @POST
    @Consumes( { MediaType.APPLICATION_JSON })
    @Produces( { MediaType.APPLICATION_JSON })
    public Response register(@RequestBody Users users){
        UsersResponse response =
                usersGroupFacade.register(users);
        return Response.status(200).entity(response).build();
    }


}
