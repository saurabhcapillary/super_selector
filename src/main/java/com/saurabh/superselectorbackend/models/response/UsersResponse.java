package com.saurabh.superselectorbackend.models.response;

import com.saurabh.superselectorbackend.models.BaseEntity;
import com.saurabh.superselectorbackend.models.Status;
import com.saurabh.superselectorbackend.models.Users;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by saurabh on 17/1/16.
 */
@XmlRootElement(name = "root")
public class UsersResponse extends BaseEntity {
     private Users users;

    private Status status;

    public void setStatus(Status status) {
        this.status = status;
    }

    public UsersResponse(Users users) {
        this.users = users;
        status = new Status();
    }

    public UsersResponse() {
        status = new Status();
    }

    @XmlElement(name = "users")
    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @XmlElement(name = "status")
    public Status getStatus() {
        return status;
    }
}
