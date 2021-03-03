package com.matheusmf.coworking.application.like;

import com.matheusmf.coworking.domain.place.model.Place;

public interface SendLikeNotification {

    void sendToPlace(Place place);

}
