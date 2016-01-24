package com.saurabh.superselectorbackend.service;
import com.saurabh.superselectorbackend.dao.CountryDao;
import com.saurabh.superselectorbackend.models.Country;
import com.saurabh.superselectorbackend.models.Status;
import com.saurabh.superselectorbackend.models.response.CountryResponse;
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
public class CountryFacade {
    
    @Inject
    private CountryDao countryDao;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public CountryResponse getCountries(long seriesId) {
       CountryResponse response = new CountryResponse();
       Status status=null;
        try {
            List<Country> countries =countryDao.getCountry();
            if(countries!=null & countries.size()>0){
                response.setCountries(countries);
                status =new Status(true);
            }
        } catch (Exception ex) {
            logger.info("Error while getting countries " + ex.getMessage());
            status=new Status(false);    
        }
        response.setStatus(status);
        return response;
    }
}
