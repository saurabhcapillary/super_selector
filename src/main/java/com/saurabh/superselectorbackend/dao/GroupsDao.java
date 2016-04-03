/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.dao;

import com.saurabh.superselectorbackend.models.Groups;
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
public class GroupsDao {
     private final JdbcTemplate jdbcTemplate; 
    
    @Autowired
    public GroupsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public List<Groups> getGroupByCreator(long created_by) {

        String sql = "SELECT * FROM  super_selector.groups "
                + " where created_by=:created_by ";
        RowMapper<Groups> rowMapper = new GroupsRowMapper();
        List<Groups> groups = jdbcTemplate.query(
                sql, new Object[]{created_by}, rowMapper);
        return groups;
    }
    
    
    public class GroupsRowMapper implements RowMapper
    {
            public Groups mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Groups groups = new Groups();
                    groups.setId(rs.getInt("id"));
                    groups.setName(rs.getString("name"));
                    return groups;
            }
    }
}
