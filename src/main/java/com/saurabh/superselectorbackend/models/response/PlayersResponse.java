/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.models.response;

import com.saurabh.superselectorbackend.models.Players;
import com.saurabh.superselectorbackend.models.Status;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author saurabh
 */
public class PlayersResponse {
    private List<Players> players;

    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public PlayersResponse(List<Players> players) {
        this.players = players;
        status = new Status();
    }

    public PlayersResponse() {
        status = new Status();
    }

    @XmlElement(name = "players")
    public List<Players> getPlayers() {
        return players;
    }

    public void setPlayers(List<Players> players) {
        this.players = players;
    }

    @XmlElement(name = "status")
    public Status getStatus() {
        return status;
    }
}
