package com.wivety.models;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "creationdate")
    private java.sql.Date creationdate;

    @Column(name = "modificationdate")
    private java.sql.Date modificationdate;

    @Column(name = "message")
    private String message;

    @Column(name = "product")
    private String product;

    @Column(name = "profile")
    private String profile;

    @Column(name = "active")
    private Boolean active;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
