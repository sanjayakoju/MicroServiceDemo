package com.ratingservice.controller;

import com.ratingservice.entity.Rating;
import com.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Rating rating) {
        return new ResponseEntity<>(ratingService.saveUser(rating), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(ratingService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getByAll() {
        return new ResponseEntity<>(ratingService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getByAllByUserId(@RequestParam Long userId) {
        return new ResponseEntity<>(ratingService.getAllByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/hotel")
    public ResponseEntity<?> getByAllByHotel(@RequestParam Long hotelId) {
        return new ResponseEntity<>(ratingService.getAllByHotelId(hotelId), HttpStatus.OK);
    }
}
