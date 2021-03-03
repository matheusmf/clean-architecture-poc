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
}
