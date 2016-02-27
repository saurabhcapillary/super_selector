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
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public ResponseEntity login(Users users) {
       ResponseEntity entity = new ResponseEntity();
       Status status;
        try {
            Users dbUser =
                usersDao.login(users.getEmail(),users.getMobile(),users.getPasswordHash());
            status = new Status(true);
            if(users.getId()>0) {
                entity.setData(dbUser);
            }
            return entity;
        } catch (Exception ex) {
            logger.info("Error while login " + ex.getMessage());
            status=new Status(false);    
        }
        entity.setStatus(status);
        return entity;
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
