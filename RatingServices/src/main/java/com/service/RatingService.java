package com.service;

import java.util.List;

import com.model.Rating;

public interface RatingService {

	// create
	Rating createRating(Rating rating);

	// get all
	List<Rating> getRatings();

	// get ratings by user id
	List<Rating> getRatingsByUserId(String userId);

	// get ratings by hotel id
	List<Rating> getRatingsByHotelId(String hotelId);
}
