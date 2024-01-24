package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Rating;
import com.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	RatingService ratingService;

	// create
	@PostMapping
	public ResponseEntity<Rating> createRatings(@RequestBody Rating rating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));

	}

	// get all ratings
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings() {
		return ResponseEntity.ok().body(ratingService.getRatings());

	}

	// get all ratings by user id
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable("userId") String userId) {
		return ResponseEntity.ok().body(ratingService.getRatingsByUserId(userId));

	}
	
	//get all ratings by hotel id
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable("hotelId") String hotelId) {
		return ResponseEntity.ok().body(ratingService.getRatingsByUserId(hotelId));
		
	}

}
