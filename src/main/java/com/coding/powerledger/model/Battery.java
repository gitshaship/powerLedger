package com.coding.powerledger.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Battery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long batteryId;
    private String name;
    private String postcode;
    private Long capacity;

    //constructor
    public Battery(String name, String postcode, Long capacity) {
        this.name = name;
        this.postcode = postcode;
        this.capacity = capacity;
    }

    public Battery() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }
}
