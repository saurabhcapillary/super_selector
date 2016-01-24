/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.models.response;

import com.saurabh.superselectorbackend.models.Squads;
import com.saurabh.superselectorbackend.models.Status;
import com.saurabh.superselectorbackend.models.Users;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author saurabh
 */
public class SquadResponse {
    private List<Squads> squads;

    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public SquadResponse(List<Squads> squads) {
        this.squads = squads;
        status = new Status();
    }

    public SquadResponse() {
        status = new Status();
    }

    @XmlElement(name = "squads")
    public List<Squads> getSquads() {
        return squads;
    }

    public void setSquads(List<Squads> squads) {
        this.squads = squads;
    }

    @XmlElement(name = "status")
    public Status getStatus() {
        return status;
    }
}
