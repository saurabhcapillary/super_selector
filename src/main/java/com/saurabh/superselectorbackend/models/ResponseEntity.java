package com.saurabh.superselectorbackend.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Created by saurabh on 13/10/15.
 */

@XmlRootElement
public class ResponseEntity extends BaseEntity {

    private Status status;
    private BaseEntity data;

    public ResponseEntity() {
        status = new Status();
    }

    @XmlElement
    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @XmlElement
    public BaseEntity getData() {
        return this.data;
    }

    public void setData(BaseEntity data) {
        this.data = data;
    }
}
