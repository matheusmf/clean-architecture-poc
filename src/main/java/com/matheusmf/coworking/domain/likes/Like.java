package com.matheusmf.coworking.domain.likes;

import com.matheusmf.coworking.domain.places.Place;
import lombok.Getter;
import lombok.Setter;

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
