package com.ratingservice.service;

import com.ratingservice.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating saveUser(Rating rating);

    List<Rating> getAll();

    Rating getById(Long id);

    List<Rating> getAllByUserId(Long userId);

    List<Rating> getAllByHotelId(Long hotelId);
}
