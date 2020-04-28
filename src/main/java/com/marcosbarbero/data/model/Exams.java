package com.marcosbarbero.data.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Exams {

    @Id
    private Integer id;

    private Integer customerId;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
