/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.models;

/**
 *
 * @author saurabh
 */
public class Players {
    
    private long id;
    private String name;
    private long squadId;
    private long countryId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSquadId() {
        return squadId;
    }

    public void setSquadId(long squadId) {
        this.squadId = squadId;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }
    
}
