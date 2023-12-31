package com.hotelservice.controller;

import com.hotelservice.entity.Hotel;
import com.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    public HotelService hotelService;

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Hotel hotel) {
        return new ResponseEntity<>(hotelService.saveUser(hotel), HttpStatus.CREATED);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_internal')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return new ResponseEntity<>(hotelService.getById(id), HttpStatus.OK);
    }

    @PreAuthorize("hasAnyAuthority('SCOPE_internal' || hasAnyAuthority('ADMIN'))")
    @GetMapping
    public ResponseEntity<?> getByAll() {
        return new ResponseEntity<>(hotelService.getAll(), HttpStatus.OK);
    }
}
