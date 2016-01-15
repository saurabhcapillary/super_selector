
package com.saurabh.superselectorbackend.controller;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
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
@Path("/country/")
@Controller
public class CountryResource {
     private static final Logger logger =
        LoggerFactory.getLogger(CountryResource.class);
     
    @Context
    private UriInfo context;
    
    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getCountry(@PathParam("id") @DefaultValue("0") long id){
        return Response.status(200).entity("hello").build();
    }
    
     
}
