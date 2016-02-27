/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.dao;

import com.saurabh.superselectorbackend.models.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import jersey.repackaged.com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 *
 * @author saurabh
 */

@Repository
public class UsersDao {
    private final JdbcTemplate jdbcTemplate; 
    
    @Autowired
    public UsersDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Users register(Users users){
        
        String sql = "INSERT INTO users " +
			"(name, email, mobile,countryId,state,city,passwordHash) "
                + "VALUES (:name, :email, :mobile,:countryId,:state,:city,:passwordHash)";
        
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("mobile", users.getMobile());
        paramMap.put("email", users.getEmail());
        paramMap.put("city", users.getCity());
        paramMap.put("state", users.getState());
        paramMap.put("password", users.getPasswordHash());
        paramMap.put("country_id", users.getCountryId());
        paramMap.put("name", users.getName());
        try{
          //  jdbcTemplate.update(sql, paramMap);
            
           Number id = new SimpleJdbcInsert(this.jdbcTemplate).
                    withTableName("super_selector.users").usingColumns(
                paramMap.keySet().toArray(new String[] {}))
                .usingGeneratedKeyColumns("id").executeAndReturnKey(paramMap);
            users.setId(id.longValue());
            return users;
        }
        catch(Exception ex){
            return users;
        }
    }
    
     public Users login(String email,String mobile,String passwordHash){       
         
        String sql = "SELECT * FROM  super_selector.users WHERE (email = ? OR mobile = ?) AND passwordHash = ? ";
        try{
            Users users = (Users) jdbcTemplate.queryForObject(
			sql, new Object[] { email,mobile,passwordHash }, new UserRowMapper());
		
            return users;
        }
        catch(Exception ex){
            return null;
        }      
        
    }
     
    public class UserRowMapper implements RowMapper
    {
            public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Users users = new Users();
                    users.setId(rs.getInt("id"));
                    users.setName(rs.getString("name"));
                    users.setEmail(rs.getString("email"));
                    users.setMobile(rs.getString("mobile"));
                    users.setPasswordHash(rs.getString("passwordHash"));
                    users.setCountryId(rs.getLong("countryId"));
                    users.setState(rs.getString("state"));
                    users.setCity(rs.getString("city"));
                    return users;
            }
    }
}
