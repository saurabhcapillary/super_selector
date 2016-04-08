package com.saurabh.superselectorbackend.models.response;

import com.saurabh.superselectorbackend.models.Squads;
import com.saurabh.superselectorbackend.models.Status;
import com.saurabh.superselectorbackend.models.UserPoints;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by saurabhkmr on 8/4/16 @Capillary Tech
 */
public class UsersPointsMapping {

    private List<UserPoints> userPointsList;

    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public UsersPointsMapping(List<UserPoints> userPointsList) {
        this.userPointsList = userPointsList;
        status = new Status();
    }

    public UsersPointsMapping() {
        status = new Status();
    }

    @XmlElement(name = "user_points")
    public List<UserPoints> getSquads() {
        return userPointsList;
    }

    public void setUserPointsList(List<UserPoints> userPointsList) {
        this.userPointsList = userPointsList;
    }

    @XmlElement(name = "status")
    public Status getStatus() {
        return status;
    }
}
