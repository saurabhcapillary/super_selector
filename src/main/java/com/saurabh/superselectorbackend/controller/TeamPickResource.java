package com.saurabh.superselectorbackend.controller;

import com.saurabh.superselectorbackend.models.MatchPoints;
import com.saurabh.superselectorbackend.models.Users;
import com.saurabh.superselectorbackend.models.response.MatchPointsResponse;
import com.saurabh.superselectorbackend.models.response.UsersResponse;
import com.saurabh.superselectorbackend.service.MatchPointsFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by saurabhkmr on 29/3/16.
 */

@Path("/team_select/")
@Controller
public class TeamPickResource {


    @Inject
    private MatchPointsFacade matchPointsFacade;

    @POST
    @Consumes( { MediaType.APPLICATION_JSON })
    @Produces( { MediaType.APPLICATION_JSON })
    public Response addSelectedTeam(@RequestBody MatchPointsResponse matchPoints){
        MatchPointsResponse response =
                matchPointsFacade.addSelectedTeam(matchPoints);
        return Response.status(200).entity(response).build();
    }


    @GET
    @Consumes( { MediaType.APPLICATION_JSON })
    @Produces( { MediaType.APPLICATION_JSON })
    public Response getSelectedTeam(@QueryParam("user_id")  Long userId, @QueryParam("match_id") Long matchId){
        MatchPointsResponse response =
                matchPointsFacade.getSelectedTeam(userId,matchId);
        return Response.status(200).entity(response).build();
    }


}
