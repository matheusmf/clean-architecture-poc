package com.matheusmf.coworking.domain.places.exceptions;

public class PlaceNotFound extends RuntimeException {

    public PlaceNotFound(String name) {
        super("Place not found with name: " + name);
    }
}
