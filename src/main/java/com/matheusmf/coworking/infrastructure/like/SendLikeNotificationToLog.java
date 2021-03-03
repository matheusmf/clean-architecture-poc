package com.matheusmf.coworking.infrastructure.like;

import com.matheusmf.coworking.application.like.SendLikeNotification;
import com.matheusmf.coworking.domain.place.model.Place;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SendLikeNotificationToLog implements SendLikeNotification {

    @Override
    public void sendToPlace(Place place) {
        log.info(String.format("%s received a new like", place.getName()));
    }
}
