package com.wivety.models;

import javax.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "product")
    private String product;

    @Column(name = "quantity")
    private Long quantity;

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

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
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
