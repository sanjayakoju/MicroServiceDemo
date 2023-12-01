package com.hotelservice.service;

import com.hotelservice.entity.Hotel;
import com.hotelservice.exception.ResourceNotFoundException;
import com.hotelservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    public HotelRepository hotelRepository;

    @Override
    public Hotel saveUser(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getById(Long id) {
        return hotelRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Hotel Not Found!!"));
    }
}
