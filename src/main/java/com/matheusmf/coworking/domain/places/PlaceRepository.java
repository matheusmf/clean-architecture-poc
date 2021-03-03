package com.matheusmf.coworking.domain.places;

import java.util.List;

public interface PlaceRepository {

    void register(Place place);

    Place findByName(String name);

    List<Place> listAll();
}
