package com.saurabh.superselectorbackend.controller;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.saurabh.superselectorbackend.models.response.MatchesResponse;
import com.saurabh.superselectorbackend.service.MatchesFacade;
import com.saurabh.superselectorbackend.service.PlayerFacade;
import org.springframework.stereotype.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saurabh
 */
@Path("/matches/")
@Controller
public class MatchesResource {

    @Inject
    private MatchesFacade matchesFacade;

    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getMatches(@QueryParam("seriesName")  String seriesName
            ,@QueryParam("upcoming")  boolean isUpcoming){
         MatchesResponse response=matchesFacade.getMatches(seriesName,isUpcoming);
        return Response.status(200).entity(response).build();
    }

}
