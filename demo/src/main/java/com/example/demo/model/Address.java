package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Address {
    private final UUID id;

    private final String streetstreet;

    private final String city;

    private final String state;

    private final String postalCode;


    public Address(@JsonProperty("id") UUID id,
                   @JsonProperty("streetstreet") String streetstreet,
                   @JsonProperty("city") String city,
                   @JsonProperty("state") String state,
                   @JsonProperty("postalCode") String postalCode) {

        this.id = id;
        this.streetstreet = streetstreet;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public UUID getId() {
        return id;
    }

    public String getStreet() {
        return streetstreet;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

}
