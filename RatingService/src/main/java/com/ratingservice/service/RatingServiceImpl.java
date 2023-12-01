package com.ratingservice.service;

import com.ratingservice.entity.Rating;
import com.ratingservice.exception.ResourceNotFoundException;
import com.ratingservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating saveUser(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepository.findAll();
    }

    @Override
    public Rating getById(Long id) {
        return ratingRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Rating Not Found!"));
    }

    @Override
    public List<Rating> getAllByUserId(Long userId) {
        return ratingRepository.findAllByUserId(userId);
    }

    @Override
    public List<Rating> getAllByHotelId(Long hotelId) {
        return ratingRepository.findAllByHotelId(hotelId);
    }
}
