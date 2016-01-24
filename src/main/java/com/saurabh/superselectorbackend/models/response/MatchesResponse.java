/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.models.response;
import com.saurabh.superselectorbackend.models.Matches;
import com.saurabh.superselectorbackend.models.Status;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author saurabh
 */
public class MatchesResponse {
    private List<Matches> matches;

    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public MatchesResponse(List<Matches> matches) {
        this.matches = matches;
        status = new Status();
    }

    public MatchesResponse() {
        status = new Status();
    }

    @XmlElement(name = "matches")
    public List<Matches> getMatches() {
        return matches;
    }

    public void setMatches(List<Matches> matches) {
        this.matches = matches;
    }

    @XmlElement(name = "status")
    public Status getStatus() {
        return status;
    }
}
