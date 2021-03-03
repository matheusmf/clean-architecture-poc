package com.matheusmf.coworking.domain.places;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Place {

    private String name;
    private Address address;
    private Email email;
    private List<Phone> phones = new ArrayList<>();

    public Place(String name, Address address, Email email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public void addPhone(String ddd, String number) {
        this.phones.add(new Phone(ddd, number));
    }

}
