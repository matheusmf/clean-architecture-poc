package com.matheusmf.coworking.domain.place.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Place {

    @Getter
    private String name;
    @Getter
    private Address address;
    private Email email;
    @Getter
    private List<Phone> phones = new ArrayList<>();

    public Place(String name, Email email) {
        this.name = name;
        this.email = email;
    }

    public void setAddress(String country, String state, String city, String district, String street, String complement) {
        this.address = new Address(country, state, city, district, street, complement);
    }

    public void addPhone(String ddd, String number) {
        this.phones.add(new Phone(ddd, number));
    }

    public String getEmail() {
        return email.getAddress();
    }

}
