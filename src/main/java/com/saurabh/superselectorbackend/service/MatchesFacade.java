package com.saurabh.superselectorbackend.service;

import com.saurabh.superselectorbackend.dao.MatchesDao;
import com.saurabh.superselectorbackend.models.Matches;
import com.saurabh.superselectorbackend.models.Squads;
import com.saurabh.superselectorbackend.models.Status;
import com.saurabh.superselectorbackend.models.response.MatchesResponse;
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
public class MatchesFacade {
    
    @Inject
    private MatchesDao matchesDao;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public MatchesResponse getMatches(String seriesName,boolean isUpComing) {
       MatchesResponse response = new MatchesResponse();
        logger.info("Getting matches");
       Status status;
        try {
            List<Matches> matches=null;
            if(isUpComing){
                matches = matchesDao.getUpcomingMatches(seriesName);
            }
            else {
                 matches = matchesDao.getMatches(seriesName);
            }
            response.setMatches(matches);
            status =new Status(true);
        } catch (Exception ex) {
            logger.error("Error while getting matches " ,ex);
            status=new Status(false);    
        }
        response.setStatus(status);
        return response;
    }
}
