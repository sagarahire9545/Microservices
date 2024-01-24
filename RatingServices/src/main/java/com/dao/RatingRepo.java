package com.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.model.Rating;

@Repository
public interface RatingRepo extends MongoRepository<Rating, String> {

	//custom methods
	List<Rating> findByUserId(String userId);

	List<Rating> findByHotelId(String hotelId);

}
