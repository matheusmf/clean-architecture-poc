package com.matheusmf.coworking.domain.places;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Place {

    private String name;
    private Address address;
    private Email email;
    private List<Phone> phones = new ArrayList<>();

    public Place(String name, Email email) {
        this.name = name;
        this.email = email;
    }

    public void setAddress(String country, String state, String city, String street, String complement) {
        this.address = new Address(country, state, city, street, complement);
    }

    public void addPhone(String ddd, String number) {
        this.phones.add(new Phone(ddd, number));
    }

}
