package com.wivety.models;

import javax.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "creationdate")
    private java.sql.Date creationdate;

    @Column(name = "modificationdate")
    private java.sql.Date modificationdate;

    @Column(name = "active")
    private Boolean active;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public java.sql.Date getCreationdate() {
        return this.creationdate;
    }

    public void setCreationdate(java.sql.Date creationdate) {
        this.creationdate = creationdate;
    }

    public java.sql.Date getModificationdate() {
        return this.modificationdate;
    }

    public void setModificationdate(java.sql.Date modificationdate) {
        this.modificationdate = modificationdate;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
