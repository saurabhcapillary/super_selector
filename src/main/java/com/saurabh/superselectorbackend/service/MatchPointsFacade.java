package com.saurabh.superselectorbackend.service;

import com.saurabh.superselectorbackend.dao.MatchPointsDao;
import com.saurabh.superselectorbackend.models.MatchPoints;
import com.saurabh.superselectorbackend.models.Status;
import com.saurabh.superselectorbackend.models.response.MatchPointsResponse;
import com.saurabh.superselectorbackend.util.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by saurabhkmr on 29/3/16.
 */
@Service
public class MatchPointsFacade {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private MatchPointsDao matchPointsDao;


    public MatchPointsResponse getUserPoints(Long userId,Long matchId){
        MatchPointsResponse response = new MatchPointsResponse();
        Status status;
        try {
            Long  points;
            if(matchId==null){
                 points= matchPointsDao.getTotalPoints(userId);
            }
            else{
                points= matchPointsDao.getMatchPoints(userId, matchId);
            }
            status =new Status(true);
            response.setPoints(points);
        } catch (Exception ex) {
            logger.info("Error while getting user points " + ex.getMessage());
            status=new Status(false);
        }
        response.setStatus(status);
        return response;
    }


    public MatchPointsResponse addSelectedTeam(MatchPointsResponse matchPointsResponse) {
        MatchPointsResponse response = new MatchPointsResponse();
        Status status;
        try {
            matchPointsDao.addSelectedTeam(matchPointsResponse.getMatchPoints());
            status =new Status(true);
        } catch (Exception ex) {
            logger.info("Error while adding selected team " + ex.getMessage());
            status=new Status(false);
        }
        response.setStatus(status);
        return response;
    }

    public MatchPointsResponse getSelectedTeam(Long userId, Long matchId) {
        MatchPointsResponse response = new MatchPointsResponse();
        Status status;
        try {
            List<MatchPoints> selectedTeam = matchPointsDao.getSelectedTeam(userId, matchId);
            response.setMatchPoints(selectedTeam);
            status =new Status(true);
        } catch (Exception ex) {
            logger.info("Error while getting selected team " + ex.getMessage());
            status=new Status(false);
        }
        response.setStatus(status);
        return response;
    }

    public MatchPointsResponse updateSelectedTeam(MatchPointsResponse matchPointsRequest) {
        MatchPointsResponse response = new MatchPointsResponse();
        Status status;
        try {
            List<MatchPoints> matchPoints=matchPointsRequest.getMatchPoints();
            for(MatchPoints mp: matchPoints){
                mp.setPoints(Utils.calculatePoints(mp));
            }
            matchPointsDao.updateSelectedTeam(matchPoints);
            status =new Status(true);
        } catch (Exception ex) {
            logger.info("Error while getting selected team " + ex.getMessage());
            status=new Status(false);
        }
        response.setStatus(status);
        return response;
    }

}