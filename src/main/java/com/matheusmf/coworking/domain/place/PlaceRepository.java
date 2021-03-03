package com.matheusmf.coworking.domain.place;

import com.matheusmf.coworking.domain.place.model.Place;

import java.util.List;

public interface PlaceRepository {

    void register(Place place);

    Place findByName(String name);

    List<Place> listAll();
}
