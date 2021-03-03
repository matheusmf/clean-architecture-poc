package com.matheusmf.coworking.domain.like;

import com.matheusmf.coworking.domain.like.model.Like;
import com.matheusmf.coworking.domain.place.model.Place;

public interface LikeRepository {

    void save(Like like);

    long countByPlace(Place place);
}
