package com.wivety.models;

import javax.persistence.*;
import javax.swing.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "profile")
    private String profile;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Long price;

    @Column(name = "creationdate")
    private java.sql.Date creationdate;

    @Column(name = "modificationdate")
    private java.sql.Date modificationdate;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setPrice(Long price) {
        this.price = price;
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
