package com.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HotelRepository;
import com.exception.ResourceNotFoundException;
import com.model.Hotel;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {

		// set hotel random user id
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel get(String id) {
		return hotelRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
	}

}
