package com.saurabh.superselectorbackend.service;

import com.saurabh.superselectorbackend.dao.UsersDao;
import com.saurabh.superselectorbackend.models.ResponseEntity;
import com.saurabh.superselectorbackend.models.Status;
import com.saurabh.superselectorbackend.models.Users;
import com.saurabh.superselectorbackend.models.response.UsersResponse;
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
public class UsersGroupFacade {

    @Inject
    private UsersDao usersDao;

    @Inject
    private MatchPointsFacade matchPointsFacade;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public UsersResponse login(Users users) {
        UsersResponse usersResponse = new UsersResponse();
        Status status;
        try {
            List<Users> dbUser =
                    usersDao.login(users.getEmail(), users.getMobile(), users.getPasswordHash());
            status = new Status(true);
            if (dbUser.size() > 0) {
                dbUser.get(0).setTotalPoints(matchPointsFacade.getUserPoints(dbUser.get(0).getId(),null).getPoints());
                usersResponse.setUsers(dbUser.get(0));
            }
        } catch (Exception ex) {
            logger.info("Error while login " + ex.getMessage());
            status = new Status(false);
        }
        usersResponse.setStatus(status);
        return usersResponse;
    }
    
    public UsersResponse register(Users users) {
       UsersResponse response = new UsersResponse();
       Status status=null;
        try {
            Users dbUser =
                usersDao.register(users);
            status =new Status(true);
            if(dbUser.getId()>0){
                response.setUsers(dbUser);
            }
        } catch (Exception ex) {
            logger.info("Error while register " + ex.getMessage());
            status=new Status(false);    
        }
        response.setStatus(status);
        return response;
    }
    
}
