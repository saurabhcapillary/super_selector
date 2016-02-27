/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.dao;

import com.saurabh.superselectorbackend.models.Players;
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
public class PlayersDao {
     private final JdbcTemplate jdbcTemplate; 
    
    @Autowired
    public PlayersDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Players> getPlayers(long squadId){
        
           String sql = "SELECT * FROM  super_selector.players "
                   + " where squad_id="+squadId;
        try{
            RowMapper<Players> rowMapper = new PlayersRowMapper();
             List<Players> players =  jdbcTemplate.query(
			sql, rowMapper);
            return players;
        }
        catch(Exception ex){
            return null;
        }     
    }
    
    
    public class PlayersRowMapper implements RowMapper
    {
            public Players mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Players players = new Players();
                    players.setId(rs.getInt("id"));
                    players.setName(rs.getString("name"));
                    players.setCountryId(rs.getInt("country_id"));
                    players.setSquadId(rs.getInt("squad_id"));
                    return players;
            }
    }
}
