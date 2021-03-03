package com.matheusmf.coworking.domain.places;

public class PlaceBuilder {

    private Place place;

    public PlaceBuilder withNameAddressEmail(String name, String email) {
        this.place = new Place(name, new Email(email));
        return this;
    }

    public PlaceBuilder withAddress(String country, String state, String city, String street, String complement) {
        this.place.setAddress(country, state, city, street, complement);
        return this;
    }

    public PlaceBuilder withPhone(String ddd, String number) {
        this.place.addPhone(ddd, number);
        return this;
    }

    public Place build() {
        return place;
    }
}
