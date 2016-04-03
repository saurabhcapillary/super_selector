package com.saurabh.superselectorbackend.dao;

import com.saurabh.superselectorbackend.models.MatchPoints;
import com.saurabh.superselectorbackend.models.Matches;
import jersey.repackaged.com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by saurabhkmr on 29/3/16.
 */

@Repository
public class MatchPointsDao {

    NamedParameterJdbcTemplate jdbcTemplate;

    @Inject
    private MatchesDao matchesDao;


    @Autowired
    public MatchPointsDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long getMatchPoints(long userId,long matchId) {

        String sql = "select sum(points) from match_points " +
                "where match_id=:match_id and user_id=:user_id group by match_id";
        try {
            Map<String, Object> paramMap = Maps.newHashMap();
            paramMap.put("match_id",matchId);
            paramMap.put("user_id",userId);
            Long matchPoints= jdbcTemplate.queryForObject(sql,paramMap,Long.class);
            return matchPoints;
        } catch (Exception ex) {
            return 0L;
        }
    }

    public Long getTotalPoints(long userId) {

        String sql = "SELECT sum(points) FROM  super_selector.match_points where user_id=:user_id";
        try {
            Map<String, Object> paramMap = Maps.newHashMap();
            paramMap.put("user_id",userId);
            Long matchPoints= jdbcTemplate.queryForObject(sql,paramMap,Long.class);
            return matchPoints;
        } catch (Exception ex) {
            return 0L;
        }
    }

    public void addSelectedTeam(List<MatchPoints> matchPoints) {

        String sql = "INSERT INTO match_points " +
                "(user_id, player_id, match_id,points) "
                + "VALUES (:user_id, :player_id, :match_id,:points)";

        try{
            for(MatchPoints mp : matchPoints){
                Map<String, Object> paramMap = Maps.newHashMap();
                paramMap.put("match_id", mp.getMatchId());
                paramMap.put("player_id",mp.getPlayerId());
                paramMap.put("user_id",mp.getUserId());
                paramMap.put("points",0);
                jdbcTemplate.update(sql,paramMap);
            }
        }
        catch(Exception ex){
            return ;
        }
    }

    public List<MatchPoints> getSelectedTeam(Long userId,Long matchId){
        String sql = "select mp.id,mp.user_id,mp.match_id,mp.player_id,mp.points,p.name from match_points as mp LEFT JOIN players as p on mp.player_id=p.id " +
                " left join matches as m on mp.match_id= m.id" +
                " where match_id=:match_id and user_id=:user_id ";
        try {
            Map<String, Object> paramMap = Maps.newHashMap();
            paramMap.put("match_id",matchId);
            paramMap.put("user_id", userId);
            RowMapper<MatchPoints> mapper= new MatchesPointsMapper();
            List<MatchPoints> matchPoints= jdbcTemplate.query(sql,paramMap,mapper);
            return matchPoints;
        } catch (Exception ex) {
            return null;
        }
    }


    public class MatchesPointsMapper implements RowMapper
    {
        public MatchPoints mapRow(ResultSet rs, int rowNum) throws SQLException {
            MatchPoints matchPoints = new MatchPoints();
            matchPoints.setId(rs.getInt("id"));
            matchPoints.setUserId(rs.getInt("user_id"));
            matchPoints.setPlayerId(rs.getInt("player_id"));
            matchPoints.setMatchId(rs.getInt("match_id"));
            matchPoints.setPoints(rs.getInt("points"));
            matchPoints.setPlayerName(rs.getString("name"));
            Matches match = matchesDao.getMatchInfoById(rs.getLong("match_id"));
            matchPoints.setMatchName(match.getHomeTeam()+" vs "+match.getAwayTeam());
            return matchPoints;
        }
    }

}
