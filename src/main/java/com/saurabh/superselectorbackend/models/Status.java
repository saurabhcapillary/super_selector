/*
 * 
 */
package com.saurabh.superselectorbackend.models;


import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Holds Status for an Object
 *
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Status extends BaseEntity {

    private static Logger logger = LoggerFactory.getLogger(Status.class);
    
    private int code;
    private boolean success;
    private String message;

    public void setCode(int code) {
        this.code = code;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Status() {
    }
    
    public Status(boolean Success){
        if(Success){
        setCode(200);
            setSuccess(true);
            setMessage("Success");
        }
        else{
            setCode(500);
            setSuccess(false);
            setMessage("Failure");
        }
        setMessage(message);
    }

  
    @XmlElement(name = "code")
    public int getCode() {
        return code;
    }

    @XmlElement(name = "message")
    public String getMessage() {
        return message;
    }
  

    @XmlElement(name = "success")
    public boolean isSuccess() {
        return success;
    }

}
