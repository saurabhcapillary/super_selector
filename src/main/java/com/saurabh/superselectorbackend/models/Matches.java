/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.models;

import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

/**
 *
 * @author saurabh
 */
public class Matches {
    
    private long id;
    private String name;
    private String venue;
    private Date date;
    private long countryId;
    private long seriesId;
    private long squadId1;
    private long squadId2;
    private String homeTeam;
    private String awayTeam;

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

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public long getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(long seriesId) {
        this.seriesId = seriesId;
    }

    @XmlTransient
    public long getSquadId1() {
        return squadId1;
    }

    public void setSquadId1(long squadId1) {
        this.squadId1 = squadId1;
    }

    @XmlTransient
    public long getSquadId2() {
        return squadId2;
    }

    public void setSquadId2(long squadId2) {
        this.squadId2 = squadId2;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }
}
