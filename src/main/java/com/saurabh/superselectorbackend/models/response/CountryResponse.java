/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saurabh.superselectorbackend.models.response;

import com.saurabh.superselectorbackend.models.Country;
import com.saurabh.superselectorbackend.models.Status;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 *
 * @author saurabh
 */
public class CountryResponse {
     private List<Country> countries;

    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public CountryResponse(List<Country> countries) {
        this.countries = countries;
        status = new Status();
    }

    public CountryResponse() {
        status = new Status();
    }

    @XmlElementWrapper(name = "countries")
    @XmlElement(name="country")
    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @XmlElement(name = "status")
    public Status getStatus() {
        return status;
    }
}
