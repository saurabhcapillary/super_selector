/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.models.response;

import com.saurabh.superselectorbackend.models.Groups;
import com.saurabh.superselectorbackend.models.Status;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author saurabh
 */
public class GroupResponse {
     private List<Groups> groups;

    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public GroupResponse(List<Groups> groups) {
        this.groups = groups;
        status = new Status();
    }

    public GroupResponse() {
        status = new Status();
    }

    @XmlElement(name = "groups")
    public List<Groups> getGroups() {
        return groups;
    }

    public void setPlayers(List<Groups> groups) {
        this.groups = groups;
    }

    @XmlElement(name = "status")
    public Status getStatus() {
        return status;
    }
}
