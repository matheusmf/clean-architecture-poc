package com.matheusmf.coworking.domain.place.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private String country;
    private String state;
    private String city;
    private String street;
    private String district;
    private String complement;

    public Address(String country, String state, String city,
                   String district, String street, String complement) {
        if (country == null || country.isEmpty()
                || state == null || state.isEmpty()
                || city == null || city.isEmpty()
                || district == null || district.isEmpty()
                || street == null || street.isEmpty()) {
            throw new IllegalArgumentException("Country, State, City, District and Street are required!");
        }

        this.country = country;
        this.state = state;
        this.city = city;
        this.district = district;
        this.street = street;
        this.complement = complement;
    }
}
