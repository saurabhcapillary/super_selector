/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.dao;

import com.saurabh.superselectorbackend.models.Matches;
import com.saurabh.superselectorbackend.models.Squads;
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

import javax.inject.Inject;

/**
 *
 * @author saurabh
 */
@Repository
public class MatchesDao {
    
    private JdbcTemplate jdbcTemplate;

    @Inject
    private SquadsDao squadsDao;
    
    @Autowired
    public MatchesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Matches> getMatches(String seriesName) {

        String sql = "SELECT * FROM  super_selector.matches AS m LEFT JOIN "
                + "super_selector.series as s on m.series_id=s.id WHERE"
                + " s.name='" + seriesName + "'";
        RowMapper<Matches> rowMapper = new MatchesRowMapper();
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("name", seriesName);
        List<Matches> matches = jdbcTemplate.query(sql, rowMapper);
        return matches;
    }

    public List<Matches> getUpcomingMatches(String seriesName) {

        String sql = "SELECT * FROM  super_selector.matches AS m  LEFT JOIN " +
                "super_selector.series as s on m.series_id=s.id  WHERE " +
                "s.name='" + seriesName + "' and m.date < DATE_ADD(NOW(), INTERVAL 14 HOUR)";
        RowMapper<Matches> rowMapper = new MatchesRowMapper();
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("name", seriesName);
        List<Matches> matches = jdbcTemplate.query(sql, rowMapper);
        return matches;
    }

    public Matches getMatchInfoById(Long id) {
        String sql = "SELECT * FROM  super_selector.matches where id=" + id;
        RowMapper<Matches> rowMapper = new MatchesRowMapper();
        Matches match = jdbcTemplate.queryForObject(sql, rowMapper);
        return match;
    }


    public class MatchesRowMapper implements RowMapper
    {
            public Matches mapRow(ResultSet rs, int rowNum) throws SQLException {
                Matches matches = new Matches();
                matches.setId(rs.getInt("id"));
                matches.setCountryId(rs.getInt("country_id"));
                matches.setSeriesId(rs.getInt("series_id"));
                matches.setVenue(rs.getString("venue"));
                matches.setSquadId1(rs.getLong("squad_id_1"));
                matches.setSquadId2(rs.getLong("squad_id_2"));
                matches.setDate(rs.getTimestamp("date"));
                Squads squad1=squadsDao.getSquadById(rs.getLong("squad_id_1"));
                Squads squad2=squadsDao.getSquadById(rs.getLong("squad_id_2"));
                if(squad1!=null && squad2!=null) {
                    matches.setHomeTeam(squad1.getShortName());
                    matches.setAwayTeam(squad2.getShortName());
                }
                return matches;
            }
    }
}
