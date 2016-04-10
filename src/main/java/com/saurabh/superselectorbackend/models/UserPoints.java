package com.saurabh.superselectorbackend.models;

/**
 * Created by saurabhkmr on 8/4/16 @Capillary Tech
 */
public class UserPoints {
    private long  userId;
    private String name;
    private long points;
    private int rank;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
