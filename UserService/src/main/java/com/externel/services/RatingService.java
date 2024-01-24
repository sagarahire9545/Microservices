package com.externel.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.model.Rating;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	// GET

	// POST

	@PostMapping("/ratings")
	public ResponseEntity<Rating> createRating(Rating rating);

	// PUT
	@PutMapping("/ratings/{ratingId}")
	public ResponseEntity<Rating> updateRating(@PathVariable String ratingId, Rating upRating);

	// DELETE

	@DeleteMapping("/ratings/{ratingId}")
	public ResponseEntity<Rating> deleteRating(String ratingId);
}
