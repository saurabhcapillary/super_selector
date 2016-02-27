package com.saurabh.superselectorbackend.models;

/**
 * Created by saurabhkmr on 27/2/16.
 */
public class Series {
    private long id;
    private String name;
    private long countryId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
