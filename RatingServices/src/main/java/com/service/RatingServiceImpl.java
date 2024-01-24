package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RatingRepo;
import com.model.Rating;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingRepo ratingRepo;

	@Override
	public Rating createRating(Rating rating) {
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
		return ratingRepo.findAll();
	}

	@Override
	public List<Rating> getRatingsByUserId(String userId) {
		return ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingsByHotelId(String hotelId) {
		return ratingRepo.findByHotelId(hotelId);
	}

}
