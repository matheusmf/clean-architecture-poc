package com.matheusmf.coworking.domain.places;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {

    private String country;
    private String state;
    private String city;
    private String street;
    private String complement;

    public Address(String country, String state, String city, String street, String complement) {
        if (country == null || country.isEmpty()
                || state == null || state.isEmpty()
                || city == null || city.isEmpty()
                || street == null || street.isEmpty()) {
            throw new IllegalArgumentException("Country, State, City and Street are required!");
        }

        this.country = country;
        this.state = state;
        this.city = city;
        this.street = street;
        this.complement = complement;
    }
}
