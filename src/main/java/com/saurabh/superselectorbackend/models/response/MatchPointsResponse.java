package com.saurabh.superselectorbackend.models.response;
import com.saurabh.superselectorbackend.models.MatchPoints;
import com.saurabh.superselectorbackend.models.Status;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by saurabhkmr on 2/4/16.
 */
public class MatchPointsResponse  {

    private Long points;

    private List<MatchPoints> matchPoints;

    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public MatchPointsResponse() {
        status = new Status();
    }

    @XmlElement(name = "points")
    public Long getPoints() {
        return points;
    }

    public void setPoints(Long points) {
        this.points = points;
    }

    public List<MatchPoints> getMatchPoints() {
        return matchPoints;
    }

    public void setMatchPoints(List<MatchPoints> matchPoints) {
        this.matchPoints = matchPoints;
    }

    @XmlElement(name = "status")
    public Status getStatus() {
        return status;
    }
}
