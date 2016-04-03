package com.saurabh.superselectorbackend;
import com.saurabh.superselectorbackend.controller.*;

import javax.ws.rs.ApplicationPath;

import com.saurabh.superselectorbackend.filters.AuthFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saurabh
 */
@Component
@ApplicationPath("v1")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(){
        register(AuthFilter.class);
        register(SquadResource.class);
        register(CountryResource.class);
        register(PlayerResource.class);
        register(UserResource.class);
        register(MatchesResource.class);
        register(TeamPickResource.class);
    }
    
}
