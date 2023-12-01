package com.userservice.controller;

import com.userservice.entity.User;
import com.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    int retryCount = 1;

    @Autowired
    public UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        logger.info("Retry Count:  {} ", retryCount);
        retryCount++;
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getByAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    // parameter and return type should need to be same with the method
    public ResponseEntity<?> ratingHotelFallback(Long id, Exception ex) {
        retryCount = 1;
        logger.info("Fallback is executed because service is down : ", ex.getMessage());
        User user = User.builder()
                .name("dummy")
                .email("dummy@gmail.com")
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
