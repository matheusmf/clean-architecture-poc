package com.matheusmf.coworking.infrastructure.place.repository;

import com.matheusmf.coworking.domain.place.PlaceRepository;
import com.matheusmf.coworking.domain.place.exception.PlaceNotFound;
import com.matheusmf.coworking.domain.place.model.Place;

import java.util.ArrayList;
import java.util.List;

public class MemoryPlaceRepository implements PlaceRepository {

    private List<Place> registeredPlaces = new ArrayList<>();

    @Override
    public void register(Place place) {
        this.registeredPlaces.add(place);
    }

    @Override
    public Place findByName(String name) {
        return this.registeredPlaces.stream()
                        .filter(place -> place.getName().equals(name))
                        .findFirst()
                        .orElseThrow(() -> new PlaceNotFound(name));
    }

    @Override
    public List<Place> listAll() {
        return this.registeredPlaces;
    }
}
