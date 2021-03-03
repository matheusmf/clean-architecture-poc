package com.matheusmf.coworking.domain.like.model;

import com.matheusmf.coworking.domain.place.model.Place;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Like {

    private Place place;
    private LocalDateTime likeDate;

    public Like(Place place) {
        this.place = place;
        this.likeDate = LocalDateTime.now();
    }
}
