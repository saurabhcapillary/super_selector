package com.saurabh.superselectorbackend.controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.saurabh.superselectorbackend.models.response.PlayersResponse;
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
@Path("/players/")
@Controller
public class PlayerResource {

    @Inject
    private PlayerFacade playerFacade;

    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getCountry(@PathParam("squadId") @DefaultValue("0") long squadId){
        PlayersResponse response=playerFacade.getPlayers(squadId);
        return Response.status(200).entity(response).build();

    }
    
}
