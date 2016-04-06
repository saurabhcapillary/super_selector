package com.saurabh.superselectorbackend.service;

import com.saurabh.superselectorbackend.dao.PlayersDao;
import com.saurabh.superselectorbackend.models.Country;
import com.saurabh.superselectorbackend.models.Players;
import com.saurabh.superselectorbackend.models.Status;
import com.saurabh.superselectorbackend.models.response.CountryResponse;
import com.saurabh.superselectorbackend.models.response.PlayersResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

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
public class PlayerFacade {


    @Inject
    private PlayersDao playersDao;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public PlayersResponse getPlayers(long squadId) {
        PlayersResponse response = new PlayersResponse();
        Status status;
        try {
            List<Players> players =playersDao.getPlayers(squadId);
            status =new Status(true);
            response.setPlayers(players);
        } catch (Exception ex) {
            logger.error("Error while getting players {0}", ex);
            status=new Status(false);
        }
        response.setStatus(status);
        return response;
    }
}
