package com.matheusmf.coworking.infrastructure.like;

import com.matheusmf.coworking.application.like.SendLikeNotification;
import com.matheusmf.coworking.domain.place.model.Place;

public class SendLikeNotificationToLog implements SendLikeNotification {

    @Override
    public void sendToPlace(Place place) {
        System.out.println(place.getName() + " received a new like");
    }
}
