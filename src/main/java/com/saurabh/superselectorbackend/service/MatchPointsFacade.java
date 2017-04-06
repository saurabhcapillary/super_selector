package com.saurabh.superselectorbackend.service;

import com.saurabh.superselectorbackend.dao.MatchPointsDao;
import com.saurabh.superselectorbackend.dao.MatchesDao;
import com.saurabh.superselectorbackend.models.MatchPoints;
import com.saurabh.superselectorbackend.models.Matches;
import com.saurabh.superselectorbackend.models.Status;
import com.saurabh.superselectorbackend.models.UserPoints;
import com.saurabh.superselectorbackend.models.response.MatchPointsResponse;
import com.saurabh.superselectorbackend.models.response.UsersPointsMapping;
import com.saurabh.superselectorbackend.util.Utils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

/**
 * Created by saurabhkmr on 29/3/16.
 */
@Service
public class MatchPointsFacade {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private MatchPointsDao matchPointsDao;

    @Inject
    private MatchesDao matchesDao;


    public MatchPointsResponse getUserPoints(Long userId,Long matchId){
        MatchPointsResponse response = new MatchPointsResponse();
        Status status;
        try {
            Long  points;
            if(matchId==null || matchId==0){
                 points= matchPointsDao.getTotalPoints(userId);
            }
            else{
                points= matchPointsDao.getMatchPoints(userId, matchId);
            }
            status =new Status(true);
            response.setPoints(points);
        } catch (Exception ex) {
            logger.error("Error while getting user points {0}" , ex);
            status=new Status(false);
        }
        response.setStatus(status);
        return response;
    }


    public UsersPointsMapping getAllUserPoints(long matchId){
        UsersPointsMapping response = new UsersPointsMapping();
        Status status;
        try {
            List<UserPoints> allUserPoints = matchPointsDao.getAllUserPoints(matchId);
            int i=1;
            for(UserPoints userpoints : allUserPoints){
                userpoints.setRank(i);
                i++;
            }
            status =new Status(true);
            response.setUserPointsList(allUserPoints);
        } catch (Exception ex) {
            logger.error("Error while getting user points {0}" , ex);
            status=new Status(false);
        }
        response.setStatus(status);
        return response;
    }




    public MatchPointsResponse addSelectedTeam(MatchPointsResponse matchPointsResponse) {
        MatchPointsResponse response = new MatchPointsResponse();
        Status status =new Status(true);;
        try {
            List<MatchPoints> matchPoints = matchPointsResponse.getMatchPoints();
            if(matchPoints.size()>0) {
                Matches matches = matchesDao.getMatchInfoById(matchPoints.get(0).getMatchId());
                Date newDate = DateUtils.addHours(new Date(), 5);
                newDate=DateUtils.addMinutes(newDate,30);

                logger.info("current time is "+newDate);
                logger.info("Match time is "+matches.getDate());
                if(matches.getDate().compareTo(newDate)<=0){
                    logger.info("Match already started {} no team selection can proceed",matches.getId());
                    status =new Status(false);
                }
                else {
                    logger.info("Match not started ,Proceed with team selection");
                    matchPointsDao.addSelectedTeam(matchPoints);
                    status =new Status(true);
                }
            }

        } catch (Exception ex) {
            logger.error("Error while adding selected team {0}" , ex);
            status=new Status(true);
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
            logger.error("Error while getting selected team {0}", ex);
            status=new Status(false);
        }
        response.setStatus(status);
        return response;
    }

    public MatchPointsResponse updateSelectedTeam(MatchPointsResponse matchPointsRequest,Long matchId) {
        MatchPointsResponse response = new MatchPointsResponse();
        Status status;
        try {
            List<MatchPoints> matchPoints=matchPointsRequest.getMatchPoints();
            for(MatchPoints mp: matchPoints){
                mp.setMatchId(matchId);
                mp.setPoints(Utils.calculatePoints(mp));
                logger.debug("Calculated match points is "+mp.getPlayerName()+" "+mp.getPoints());
            }

            matchPointsDao.updateSelectedTeam(matchPoints);
            status =new Status(true);
        } catch (Exception ex) {
            logger.info("Error while getting selected team {}" , ex);
            status=new Status(false);
        }
        response.setStatus(status);
        return response;
    }

    public MatchPointsResponse deleteSelectedTeam(Long userId, Long matchId) {
        MatchPointsResponse response = new MatchPointsResponse();
        Status status;
        try {
            long deleted = matchPointsDao.deleteSelectedTeam(userId, matchId);
            status =new Status(true);
        } catch (Exception ex) {
            logger.error("Error while getting selected team {0}", ex);
            status=new Status(false);
        }
        response.setStatus(status);
        return response;
    }
}
