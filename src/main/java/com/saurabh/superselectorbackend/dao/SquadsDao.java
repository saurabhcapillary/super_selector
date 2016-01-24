/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.dao;

import com.saurabh.superselectorbackend.models.Squads;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author saurabh
 */
public class SquadsDao {
     private final JdbcTemplate jdbcTemplate; 
    
    @Autowired
    public SquadsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Squads> getSquads(long seriesId){
        
           String sql = "SELECT * FROM  super_selector.squads "
                   + " where series_id=:seriesId ";
        try{
            RowMapper<Squads> rowMapper = new SquadsRowMapper();
             List<Squads> squads = (List<Squads>) jdbcTemplate.queryForObject(
			sql, new Object[] { seriesId }, rowMapper);
            return squads;
        }
        catch(Exception ex){
            return null;
        }     
    }
    
    
    public class SquadsRowMapper implements RowMapper
    {
            public Squads mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Squads squads = new Squads();
                    squads.setId(rs.getInt("id"));
                    squads.setName(rs.getString("name"));
                    squads.setLogo(rs.getString("logo"));
                    squads.setShortName(rs.getString("shortname"));
                    squads.setSeriesId(rs.getInt("series_id"));
                    return squads;
            }
    }
}
