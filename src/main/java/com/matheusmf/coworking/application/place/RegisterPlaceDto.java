package com.matheusmf.coworking.application.place;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterPlaceDto {

    private String name;
    private String country;
    private String state;
    private String city;
    private String street;
    private String district;
    private String complement;
    private String email;


}
