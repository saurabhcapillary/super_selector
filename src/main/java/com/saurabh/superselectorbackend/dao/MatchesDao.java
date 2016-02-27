/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.dao;

import com.saurabh.superselectorbackend.models.Matches;
import com.saurabh.superselectorbackend.models.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author saurabh
 */
@Repository
public class MatchesDao {
    
    private JdbcTemplate jdbcTemplate; 
    
    @Autowired
    public MatchesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Matches> getMatches(String seriesName){
        
           String sql = "SELECT * FROM  super_selector.matches AS m LEFT JOIN "
                   + "super_selector.series as s on m.series_id=s.id WHERE"
                   + " s.name='"+seriesName+"'";
        try{
            RowMapper<Matches> rowMapper = new MatchesRowMapper();
            Map<String, Object> valueMap = new HashMap<>();
            valueMap.put("name", seriesName);
             List<Matches> matches =jdbcTemplate.query(sql, rowMapper);
            return matches;
        }
        catch(Exception ex){
            return null;
        }     
    }
    
    
    public class MatchesRowMapper implements RowMapper
    {
            public Matches mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Matches matches = new Matches();
                    matches.setId(rs.getInt("id"));
                    matches.setName(rs.getString("name"));
                    matches.setCountryId(rs.getInt("country_id"));
                    matches.setSeriesId(rs.getInt("series_id"));
                    matches.setVenue(rs.getString("venue"));
                    return matches;
            }
    }
}
