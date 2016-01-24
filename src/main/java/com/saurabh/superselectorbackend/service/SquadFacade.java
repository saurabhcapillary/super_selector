package com.saurabh.superselectorbackend.service;

import com.saurabh.superselectorbackend.dao.SquadsDao;
import com.saurabh.superselectorbackend.models.ResponseEntity;
import com.saurabh.superselectorbackend.models.Squads;
import com.saurabh.superselectorbackend.models.Status;
import com.saurabh.superselectorbackend.models.Users;
import com.saurabh.superselectorbackend.models.response.SquadResponse;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saurabh
 */
@Service
@Component
public class SquadFacade {
    
    @Inject
    private SquadsDao squadsDao;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public SquadResponse getSquads(long seriesId) {
       SquadResponse response = new SquadResponse();
       Status status=null;
        try {
            List<Squads> squads =squadsDao.getSquads(seriesId);
            if(squads!=null & squads.size()>0){
                response.setSquads(squads);
                status =new Status(true);
            }
        } catch (Exception ex) {
            logger.info("Error while getting squads " + ex.getMessage());
            status=new Status(false);    
        }
        response.setStatus(status);
        return response;
    }
}
