package com.matheusmf.coworking.application.place;

import com.matheusmf.coworking.domain.place.PlaceRepository;
import com.matheusmf.coworking.domain.place.builder.PlaceBuilder;
import com.matheusmf.coworking.domain.place.model.Place;

public class RegisterPlaceUseCase {

    private final PlaceRepository placeRepository;

    public RegisterPlaceUseCase(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public void execute(RegisterPlaceDto data) {
        Place place = new PlaceBuilder()
                        .withNameAddressEmail(data.getName(), data.getEmail())
                        .withAddress(data.getCountry(), data.getState(), data.getCity(), data.getDistrict(), data.getStreet(), data.getComplement())
                        .build();
        placeRepository.register(place);

    }
}
