package com.matheusmf.coworking.domain.place.exception;

public class PlaceNotFound extends RuntimeException {

    public PlaceNotFound(String name) {
        super("Place not found with name: " + name);
    }
}
