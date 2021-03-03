package com.matheusmf.coworking.domain.place.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Phone {

    private String ddd;
    private String number;

    public Phone(String ddd, String number) {
        if (ddd == null || number == null) {
            throw new IllegalArgumentException("DDD and Number are required!");
        }

        if (!ddd.matches("\\d{2}")) {
            throw new IllegalArgumentException("DDD invalid!");
        }

        if (!number.matches("\\d{8}|\\d{9}")) {
            throw new IllegalArgumentException("Number invalid!");
        }
        this.ddd = ddd;
        this.number = number;
    }
}
