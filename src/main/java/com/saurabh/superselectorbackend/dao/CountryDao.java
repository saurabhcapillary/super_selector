/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.dao;

import com.saurabh.superselectorbackend.models.Country;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author saurabh
 */

@Repository
public class CountryDao {
    
    private final JdbcTemplate jdbcTemplate; 
    
    @Autowired
    public CountryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Country> getCountry(){
        
           String sql = "SELECT * FROM  super_selector.country  ";
        try{
            RowMapper<Country> rowMapper = new CountryRowMapper();
             List<Country> country = (List<Country>) jdbcTemplate.queryForObject(
			sql, new Object[] { }, rowMapper);
            return country;
        }
        catch(Exception ex){
            return null;
        }     
    }
    
    
    public class CountryRowMapper implements RowMapper
    {
            public Country mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Country country = new Country();
                    country.setId(rs.getInt("id"));
                    country.setName(rs.getString("name"));
                    country.setLogo(rs.getString("logo"));
                    country.setCode(rs.getString("code"));
                    return country;
            }
    }
}
