package com.haubui.sample.web.rest.response;

import java.io.Serializable;

public class UserResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String email;

    private String status;

    public UserResponse() {
    }

    public UserResponse(String id, String username, String email, String status) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
