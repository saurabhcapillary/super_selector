/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.dao;

import com.saurabh.superselectorbackend.models.Users;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jersey.repackaged.com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


/**
 *
 * @author saurabh
 */

@Repository
public class UsersDao {
   // private final JdbcTemplate jdbcTemplate;

    NamedParameterJdbcTemplate  jdbcTemplate;
    @Autowired
    public UsersDao(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Users register(Users users) {

        String sql = "INSERT INTO users " +
                "(name, email, mobile,country_Id,state,city,password) "
                + "VALUES (:name, :email, :mobile,:country_id,:state,:city,:password)";

        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("mobile", users.getMobile());
        paramMap.put("email", users.getEmail());
        paramMap.put("city", users.getCity());
        paramMap.put("state", users.getState());
        paramMap.put("password", users.getPasswordHash());
        paramMap.put("country_id", users.getCountryId());
        paramMap.put("name", users.getName());
        jdbcTemplate.update(sql, paramMap);
        return users;
    }
    
     public List<Users> login(String email,String mobile,String passwordHash) {

         String sql = "SELECT * FROM  super_selector.users WHERE password = :password ";

         Map<String, Object> valueMap = new HashMap<>();
         if (email != null && !email.isEmpty()) {
             sql += " AND email =:email";
             valueMap.put("email", email);
         }
         if (mobile != null && !mobile.isEmpty()) {
             sql += " AND mobile =:mobile";
             valueMap.put("mobile", mobile);
         }

         RowMapper<Users> rowMapper = new UserRowMapper();
         valueMap.put("password", passwordHash);

         List<Users> users = jdbcTemplate.query(sql, valueMap, rowMapper);
         return users;


     }
     
    public class UserRowMapper implements RowMapper {
        public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
            Users users = new Users();
            users.setId(rs.getInt("id"));
            users.setName(rs.getString("name"));
            users.setEmail(rs.getString("email"));
            users.setMobile(rs.getString("mobile"));
            users.setPasswordHash(rs.getString("password"));
            users.setCountryId(rs.getLong("country_id"));
            users.setState(rs.getString("state"));
            users.setCity(rs.getString("city"));
            return users;
        }
    }
}
