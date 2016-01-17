package com.saurabh.superselectorbackend.models;


/**
 * Created by saurabh on 13/10/15.
 */

public class ResponseEntity extends BaseEntity {

    private Status status;
    private BaseEntity data;

    public ResponseEntity() {
        status = new Status();
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BaseEntity getData() {
        return this.data;
    }

    public void setData(BaseEntity data) {
        this.data = data;
    }
}
