package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Hotel;

@Service
public interface HotelService {

	// create hotel
	Hotel createHotel(Hotel hotel);

	// getAll records hotels
	List<Hotel> getAll();

	// get single
	Hotel get(String id);

}
