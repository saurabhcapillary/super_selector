package com.saurabh.superselectorbackend.controller;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.saurabh.superselectorbackend.models.response.CountryResponse;
import com.saurabh.superselectorbackend.models.response.SquadResponse;
import com.saurabh.superselectorbackend.service.CountryFacade;
import com.saurabh.superselectorbackend.service.SquadFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Path("/squads/")
@Controller
public class SquadResource {

    private static final Logger logger =
            LoggerFactory.getLogger(CountryResource.class);

    @Context
    private UriInfo context;

    @Inject
    private SquadFacade squadFacade;

    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getSquads(@QueryParam("seriesId") @DefaultValue("0") long seriesId){
        SquadResponse response =
                squadFacade.getSquads(seriesId);
        return Response.status(200).entity(response).build();

    }
    
}
