package com.ratingservice.repository;

import com.ratingservice.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findAllByUserId(Long userId);
    List<Rating> findAllByHotelId(Long hotelId);
}
